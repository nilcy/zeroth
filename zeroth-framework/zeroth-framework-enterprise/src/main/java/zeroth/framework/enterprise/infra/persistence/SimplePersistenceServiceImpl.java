// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.infra.persistence;
import java.io.Serializable;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.TypedQuery;
import zeroth.framework.enterprise.domain.Persistable;
/**
 * 基本データ永続化サービス(JPA2)
 * <p>
 * 使用方法
 * <ol>
 * <li>はじめに {@link #setup(EntityManager, Class)} を実行する。</li>
 * <li>他のメソッドが実行できるようになる。</li>
 * <li>本クラスは状態を持つためにステートフルのため破棄が必要です。(ejbRemove)</li>
 * </ol>
 * </p>
 * @param <E> エンティティ型
 * @param <ID> 識別子オブジェクト型
 * @since JPA 1.0
 * @author nilcy
 */
@Stateful
@StatefulTimeout(value = 0, unit = TimeUnit.SECONDS)
public class SimplePersistenceServiceImpl<E extends Persistable<ID>, ID extends Serializable>
    implements SimplePersistenceService<E, ID> {
    /** 識別番号 */
    private static final long serialVersionUID = -2663309706616831662L;
    /** エンティティマネージャ */
    protected EntityManager manager;
    /** エンティティクラス */
    protected Class<E> clazz;
    /** コンストラクタ */
    public SimplePersistenceServiceImpl() {
    }
    /**
     * {@inheritDoc}
     * <p>
     * エンティティクラス、エンティティマネージャを設定する。
     * <p>
     */
    @Override
    public void setup(final EntityManager manager, final Class<E> clazz) {
        this.manager = manager;
        this.clazz = clazz;
    }
    /** {@inheritDoc} */
    @Override
    public void persist(final E entity) {
        manager.persist(entity);
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
    public E find(final ID id, final LockModeType lockModeType) {
        return manager.find(clazz, id, lockModeType);
    }
    /** {@inheritDoc} */
    @Override
    public E merge(final E entity) {
        return manager.merge(entity);
    }
    /** {@inheritDoc} */
    @Override
    public void remove(final E entity) {
        manager.remove(entity);
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
    /** EJB削除コールバック */
    @SuppressWarnings("static-method")
    @Remove
    private void ejbRemove() {
        Logger.getGlobal().info("REMOVED.");
    }
}
