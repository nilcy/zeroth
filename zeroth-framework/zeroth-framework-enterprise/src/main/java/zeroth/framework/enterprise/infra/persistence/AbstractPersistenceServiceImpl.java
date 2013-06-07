// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.infra.persistence;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.TypedQuery;
import zeroth.framework.enterprise.domain.Persistable;
/**
 * 基本データ永続化サービス
 * @param <E> エンティティ型
 * @param <ID> 識別子オブジェクト型
 * @author nilcy
 */
public abstract class AbstractPersistenceServiceImpl<E extends Persistable<ID>, ID extends Serializable>
    implements PersistenceService<E, ID> {
    /** 識別番号 */
    private static final long serialVersionUID = -2663309706616831662L;
    /** エンティティクラス */
    protected Class<E> clazz;
    /** エンティティマネージャ */
    protected EntityManager manager;
    /** コンストラクタ */
    public AbstractPersistenceServiceImpl() {
    }
    /**
     * {@inheritDoc}
     * <p>
     * エンティティクラス、エンティティマネージャを設定する。
     * <p>
     */
    @Override
    public void setup(final Class<E> clazz, final EntityManager manager) {
        this.clazz = clazz;
        this.manager = manager;
    }
    /**
     * {@inheritDoc}
     * <p>
     * 永続化して、同期する。
     * </p>
     */
    @Override
    public void persist(final E entity) {
        manager.persist(entity);
        flush();
    }
    /**
     * {@inheritDoc}
     * <p>
     * エンティティのクラスを指定して、ID検索する。
     * </p>
     */
    @Override
    public E find(final ID id) {
        return manager.find(clazz, id);
    }
    /**
     * {@inheritDoc}
     * <p>
     * エンティティのクラスを指定して、ID検索する。楽観ロック/悲観ロックなどを指定する。
     * </p>
     */
    @Override
    public E find(final Long id, final LockModeType lockModeType) {
        return manager.find(clazz, id, lockModeType);
    }
    /** {@inheritDoc} */
    @Override
    public void merge(final E entity) {
        manager.merge(entity);
        flush();
    }
    /** {@inheritDoc} */
    @Override
    public void remove(final E entity) {
        manager.remove(entity);
        flush();
    }
    /** {@inheritDoc} */
    @Override
    public void refresh(final E entity) {
        manager.refresh(entity);
    }
    /** {@inheritDoc} */
    @Override
    public void refresh(final E entity, final LockModeType lockModeType) {
        manager.refresh(entity, lockModeType);
    }
    /** {@inheritDoc} */
    @Override
    public void lock(final E entity, final LockModeType lockModeType) {
        manager.lock(entity, lockModeType);
    }
    /** {@inheritDoc} */
    @Override
    public void flush() {
        manager.flush();
    }
    /** {@inheritDoc} */
    @Override
    public void detach(final E entity) {
        manager.detach(entity);
    }
    /** {@inheritDoc} */
    @Override
    public boolean contains(final E entity) {
        return manager.contains(entity);
    }
    /** {@inheritDoc} */
    @Override
    public TypedQuery<E> createRangeQuery(final TypedQuery<E> query, final int offset,
        final int maxsize) {
        return query.setFirstResult(offset).setMaxResults(maxsize);
    }
    /** {@inheritDoc} */
    @Override
    public Collection<E> findMany(final TypedQuery<E> query) {
        return query.getResultList();
    }
    /** {@inheritDoc} */
    @Override
    public E findOne(final TypedQuery<E> query) {
        return query.getSingleResult();
    }
}
