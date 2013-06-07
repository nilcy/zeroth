// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import javax.persistence.EntityExistsException;
import javax.persistence.OptimisticLockException;
import org.apache.commons.lang3.Validate;
import zeroth.framework.enterprise.infra.persistence.PersistenceService;
import zeroth.framework.enterprise.infra.persistence.QueryPersistenceService;
import zeroth.framework.standard.shared.CommonUtils;
import zeroth.framework.standard.shared.ValueObject;
/**
 * 基本リポジトリ
 * @param <E> エンティティ型
 * @param <ID> 識別子オブジェクト型
 * @param <F> フィルタ型
 * @author nilcy
 */
public abstract class AbstractSimpleRepositoryImpl<E extends Persistable<ID>, ID extends Serializable, F extends ValueObject<?>>
    implements SimpleRepository<E, ID, F> {
    /** 識別番号 */
    private static final long serialVersionUID = -5578612922301298194L;
    /** 保護例外キー */
    private static final String KEY_LOCK_EXCEPTION = "LOCK_EXCEPTION";
    /** コンストラクタ */
    public AbstractSimpleRepositoryImpl() {
    }
    /**
     * {@inheritDoc}
     * <p>
     * データ永続化サービスでエンティティを登録して同期する。
     * </p>
     */
    @SuppressWarnings("unchecked")
    @Override
    public E save(final E entity) throws ConstraintsException {
        CommonUtils.notNull(entity);
        if (this instanceof ConstraintsUK) {
            ((ConstraintsUK<E>) this).validateUK(entity);
        }
        try {
            getPersistenceService().persist(entity);
            getPersistenceService().flush();
            return entity;
        } catch (final EntityExistsException e) {
            try {
                final E merged = getPersistenceService().merge(entity);
                getPersistenceService().flush();
                return merged;
            } catch (final OptimisticLockException e1) {
                throw new ConstraintsException(KEY_LOCK_EXCEPTION);
            }
        }
    }
    /**
     * {@inheritDoc}
     * <p>
     * データ永続化サービスでエンティティを削除して同期する。
     * </p>
     */
    @Override
    @SuppressWarnings("unchecked")
    public void delete(final E entity) throws ConstraintsException {
        Validate.notNull(entity);
        if (this instanceof ConstraintsFK) {
            ((ConstraintsFK<E>) this).validateFK(entity);
        }
        try {
            getPersistenceService().remove(getPersistenceService().merge(entity));
            getPersistenceService().flush();
        } catch (final OptimisticLockException e) {
            throw new ConstraintsException(KEY_LOCK_EXCEPTION);
        }
    }
    /**
     * {@inheritDoc}
     * <p>
     * データ永続化サービスでエンティティを閲覧する。
     * </p>
     */
    @Override
    public E find(final ID id) {
        return getPersistenceService().find(id);
    }
    /**
     * {@inheritDoc}
     * <p>
     * 必要に応じてデータ永続化サービスを使用して実装すること。(実装しないとNULL)
     * </p>
     */
    @Override
    public E findOne(final F filter) {
        return null;
    }
    /**
     * {@inheritDoc}
     * <p>
     * 必要に応じてデータ永続化サービスを使用して実装すること。(実装しないと空リスト)
     * </p>
     */
    @Override
    public Collection<E> findMany(final F filter) {
        return Collections.emptyList();
    }
    /**
     * {@inheritDoc}
     * <p>
     * 必要に応じてデータ永続化サービスを使用して実装すること。(実装しないと0)
     * </p>
     */
    @Override
    public long count(final F filter) {
        return 0;
    }
    /**
     * データ永続化サービスの取得
     * @return データ永続化サービス
     */
    protected abstract PersistenceService<E, ID> getPersistenceService();
    /**
     * 拡張データ永続化サービスの取得
     * @return 拡張データ永続化サービス
     */
    protected abstract QueryPersistenceService<E, ID> getQueryPersistenceService();
}
