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
 * @param <T> エンティティ型
 * @param <ID> 識別子オブジェクト型
 * @author nilcy
 */
public abstract class AbstractPersistenceServiceImpl<T extends Persistable<ID>, ID extends Serializable>
    implements PersistenceService<T, ID> {
    /** 識別番号 */
    private static final long serialVersionUID = -2663309706616831662L;
    /** エンティティクラス */
    protected Class<T> clazz;
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
    public void setup(final Class<T> clazz, final EntityManager manager) {
        this.clazz = clazz;
        this.manager = manager;
    }
    @Override
    public void persist(final T entity) {
        manager.persist(entity);
        flush();
    }
    @Override
    public T find(final ID id) {
        return manager.find(clazz, id);
    }
    @Override
    public T find(final Long id, final LockModeType lockModeType) {
        return manager.find(clazz, id, lockModeType);
    }
    @Override
    public void merge(final T entity) {
        manager.merge(entity);
        flush();
    }
    @Override
    public void remove(final T entity) {
        manager.remove(entity);
        flush();
    }
    @Override
    public void refresh(final T entity) {
        manager.refresh(entity);
    }
    @Override
    public void refresh(final T entity, final LockModeType lockModeType) {
        manager.refresh(entity, lockModeType);
    }
    @Override
    public void lock(final T entity, final LockModeType lockModeType) {
        manager.lock(entity, lockModeType);
    }
    @Override
    public void flush() {
        manager.flush();
    }
    @Override
    public void detach(final T entity) {
        manager.detach(entity);
    }
    @Override
    public boolean contains(final T entity) {
        return manager.contains(entity);
    }
    @Override
    public TypedQuery<T> setRange(final TypedQuery<T> query, final int begin, final int max) {
        return query.setFirstResult(begin).setMaxResults(max);
    }
    /** {@inheritDoc} */
    @Override
    public Collection<T> findMany(final TypedQuery<T> query) {
        return query.getResultList();
    }
    /** {@inheritDoc} */
    @Override
    public T findOne(final TypedQuery<T> query) {
        return query.getSingleResult();
    }
}
