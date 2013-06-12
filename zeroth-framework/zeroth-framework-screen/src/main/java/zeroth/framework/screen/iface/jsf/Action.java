// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.screen.iface.jsf;
import java.io.Serializable;
import java.util.Collection;
import zeroth.framework.enterprise.app.SimpleRepositoryService;
import zeroth.framework.enterprise.shared.Persistable;
import zeroth.framework.standard.shared.ValueObject;
/**
 * JSFアクションI/F
 * @param <E> エンティティ型
 * @param <ID> 識別子オブジェクト型
 * @param <F> 検索条件オブジェクト型
 * @author nilcy
 */
public interface Action<E extends Persistable<ID>, ID extends Serializable, F extends ValueObject<?>>
    extends Serializable {
    /**
     * Get items.
     * @return items
     */
    Collection<E> getItems();
    /**
     * Get selected object.
     * @return selected object
     */
    E getSelected();
    /**
     * Refresh.
     */
    void refresh();
    /** Begin conversation. */
    void beginConversation();
    /** End conversation. */
    void endConversation();
    /**
     * Determine if managed.
     * @return true if managed
     */
    boolean isManaged();
    /**
     * Save.
     * @return outcome
     */
    String save();
    /**
     * Delete.
     * @return outcome
     */
    String delete();
    /**
     * Cancel.
     * @return outcome
     */
    String cancel();
    /**
     * Get pagination.
     * @return pagination
     */
    Pagination<E> getPagination();
    /**
     * Get {@link SimpleRepositoryService}.
     * @return {@link SimpleRepositoryService}
     */
    SimpleRepositoryService<E, ID, F> getService();
    /**
     * Get restriction.
     * @return restriction
     */
    E getRestriction();
    /**
     * Get ID.
     * @return ID
     */
    ID getId();
    /**
     * Set ID.
     * @param aId ID
     */
    void setId(final ID aId);
    /**
     * Get current page.
     * @return current page
     */
    int getPage();
    /**
     * Set current page.
     * @param aPage current page
     */
    void setPage(final int aPage);
}
