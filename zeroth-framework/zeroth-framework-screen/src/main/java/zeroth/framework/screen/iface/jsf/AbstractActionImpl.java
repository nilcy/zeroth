// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.screen.iface.jsf;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.Map.Entry;
import javax.ejb.EJBException;
import javax.enterprise.context.Conversation;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import org.apache.commons.lang3.Validate;
import zeroth.framework.enterprise.app.SimpleRepositoryApplication;
import zeroth.framework.enterprise.domain.ConstraintsException;
import zeroth.framework.enterprise.shared.EnterpriseRuntimeException;
import zeroth.framework.enterprise.shared.Persistable;
/**
 * JSFアクション
 * @param <E> エンティティ型
 * @param <ID> 識別子オブジェクト型
 * @param <F> 検索条件オブジェクト型 TODO extends ValueObject<?>
 * @author nilcy
 */
public abstract class AbstractActionImpl<E extends Persistable<ID>, ID extends Serializable, F extends Serializable>
    implements Action<E, ID, F> {
    /** 製品番号 */
    private static final long serialVersionUID = -8034832957766744039L;
    /** ページサイズ */
    private static final int PAGE_SIZE = 10;
    /** 永続エラーのキー */
    private static final String KEY_PERSISTENCE_ERROR = "PersistenceErrorOccured";
    /** 選択オブジェクト */
    private E selected;
    /** 検索条件 */
    private F restriction;
    /** エンティティ集合 */
    private Collection<E> items;
    /** ページ条件 */
    private Pagination<E> pagination;
    /** 識別子 */
    private ID id;
    /** 現在ページ */
    private int page;
    /** 会話オブジェクト */
    @Inject
    private Conversation conversation;
    /** コンストラクタ */
    public AbstractActionImpl() {
    }
    /** {@inheritDoc} */
    @Override
    public Collection<E> getItems() {
        if (this.items == null) {
            this.items = this.getPagination().createCollection();
        }
        return this.items;
    }
    /** {@inheritDoc} */
    @Override
    public E getSelected() {
        if (this.selected == null) {
            this.selected = this.id == null ? this.createInstance() : this.loadInstance();
        }
        return this.selected;
    }
    /** {@inheritDoc} */
    @Override
    public void refresh() {
        this.items = null;
        this.pagination = null;
        return;
    }
    /** {@inheritDoc} */
    @Override
    public void beginConversation() {
        if (this.conversation.isTransient()) {
            this.conversation.setTimeout(FacesProfile.CONVERSATION_TIMEOUT);
            this.conversation.begin();
        }
    }
    /** {@inheritDoc} */
    @Override
    public void endConversation() {
        if (!this.conversation.isTransient()) {
            this.conversation.end();
        }
    }
    /** {@inheritDoc} */
    @Override
    public boolean isManaged() {
        return this.getSelected().isPersisted();
    }
    /** {@inheritDoc} */
    @Override
    public String save() {
        String outcome = null;
        try {
            if (this.beforeSave()) {
                final String key = !this.selected.isPersisted() ? "EntityCreated" : "EntityUpdated";
                this.selected = getService().save(this.selected);
                this.endConversation();
                FacesHelper.addSuccessMessage(FacesHelper.getBundleMessage(key));
                FacesHelper.keepMessage();
                FacesHelper.getFlash().put("id", this.selected.identity());
                outcome = "saved";
            }
        } catch (final ConstraintsException e) {
            for (final Entry<String, Object[]> entry : e.getCauseMap().entrySet()) {
                FacesHelper.addFacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    MessageFormat.format(FacesHelper.getBundleMessage(entry.getKey()),
                        entry.getValue()));
            }
            FacesHelper.getCurrentInstance().validationFailed();
        } catch (final EJBException e) {
            FacesHelper.addFacesMessage(FacesMessage.SEVERITY_FATAL,
                FacesHelper.getBundleMessage(KEY_PERSISTENCE_ERROR));
        }
        return outcome;
    }
    /** {@inheritDoc} */
    @Override
    public String delete() {
        String outcome = null;
        try {
            Validate.notNull(this.getId());
            this.selected = getService().find(this.getId());
            getService().delete(this.selected);
            this.endConversation();
            FacesHelper.addSuccessMessage(FacesHelper.getBundleMessage("EntityDeleted"));
            FacesHelper.keepMessage();
            outcome = "deleted";
        } catch (final ConstraintsException e) {
            for (final Entry<String, Object[]> entry : e.getCauseMap().entrySet()) {
                FacesHelper.addFacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    MessageFormat.format(FacesHelper.getBundleMessage(entry.getKey()),
                        entry.getValue()));
            }
        } catch (final EJBException e) {
            FacesHelper.addFacesMessage(FacesMessage.SEVERITY_FATAL,
                FacesHelper.getBundleMessage(KEY_PERSISTENCE_ERROR));
        }
        return outcome;
    }
    /** {@inheritDoc} */
    @Override
    public String cancel() {
        this.endConversation();
        return "cancelled";
    }
    /** {@inheritDoc} */
    @Override
    public Pagination<E> getPagination() {
        if (this.pagination == null) {
            this.pagination = new AbstractPagination<E>(PAGE_SIZE, this.page) {
                /** 項目の件数 */
                private int itemsCount;
                @Override
                public Collection<E> createCollection() {
                    final Collection<E> results = AbstractActionImpl.this.getService().findMany(
                        AbstractActionImpl.this.getRestriction());
                    this.itemsCount = (int) AbstractActionImpl.this.getService().count(
                        AbstractActionImpl.this.getRestriction());
                    return results;
                }
                @Override
                public int getItemsCount() {
                    return this.itemsCount;
                }
            };
        }
        return this.pagination;
    }
    /** {@inheritDoc} */
    @Override
    public abstract SimpleRepositoryApplication<E, ID, F> getService();
    /**
     * インスタンスのロード
     * @return インスタンス
     */
    protected E loadInstance() {
        Validate.notNull(this.getId());
        return getService().find(this.getId());
    }
    /**
     * エンティティの作成
     * @return エンティティ
     */
    @SuppressWarnings("unchecked")
    protected E createInstance() {
        try {
            return ((Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[0]).newInstance();
        } catch (final InstantiationException e) {
            throw new EnterpriseRuntimeException(e);
        } catch (final IllegalAccessException e) {
            throw new EnterpriseRuntimeException(e);
        }
    }
    /**
     * 検索条件の作成
     * @return 検索条件
     */
    @SuppressWarnings("unchecked")
    protected F createRestriction() {
        try {
            return ((Class<F>) ((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[2]).newInstance();
        } catch (final InstantiationException e) {
            throw new EnterpriseRuntimeException(e);
        } catch (final IllegalAccessException e) {
            throw new EnterpriseRuntimeException(e);
        }
    }
    /** {@inheritDoc} */
    @Override
    public F getRestriction() {
        if (this.restriction == null) {
            this.restriction = this.createRestriction();
        }
        return this.restriction;
    }
    /**
     * 保存前の処理
     * @return 成否
     */
    @SuppressWarnings("static-method")
    protected boolean beforeSave() {
        return true;
    }
    /** {@inheritDoc} */
    @Override
    public ID getId() {
        return this.id;
    }
    /** {@inheritDoc} */
    @Override
    public void setId(final ID aId) {
        this.id = aId;
    }
    /** {@inheritDoc} */
    @Override
    public int getPage() {
        return this.page;
    }
    /** {@inheritDoc} */
    @Override
    public void setPage(final int aPage) {
        this.page = aPage;
    }
}
