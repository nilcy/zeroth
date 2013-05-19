// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.infra.persistence;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import zeroth.framework.enterprise.domain.ReferenceObject;
/**
 * 汎用データ操作
 * @param <T> 参照オブジェクト型
 * @param <ID> 識別子オブジェクト型
 * @author nilcy
 */
@Stateless
public class GenericDaoImpl<T extends ReferenceObject<T, ID>, ID> implements GenericDao<T, ID> {
    /** 識別番号 */
    private static final long serialVersionUID = -2663309706616831662L;
    /** 参照オブジェクトマネージャ */
    private EntityManager manager;
    /** 参照オブジェクトクラス */
    private Class<T> clazz;
    /** コンストラクタ */
    public GenericDaoImpl() {
    }
    @Override
    public EntityManager getManager() {
        return this.manager;
    }
    @Override
    public void setManager(final EntityManager aManager) {
        this.manager = aManager;
    }
    @Override
    public void init(final Class<T> aClass) {
        this.clazz = aClass;
    }
    @Override
    public void create(final T aReferenceObject) {
        this.manager.persist(aReferenceObject);
        flush();
    }
    @Override
    public T read(final ID aId) {
        return this.manager.find(this.clazz, aId);
    }
    @Override
    public T read(final Long aId, final LockModeType aLockModeType) {
        return this.manager.find(this.clazz, aId, aLockModeType);
    }
    @Override
    public void update(final T aReferenceObject) {
        this.manager.merge(aReferenceObject);
        flush();
    }
    @Override
    public void delete(final T aReferenceObject) {
        this.manager.remove(aReferenceObject);
        flush();
    }
    @Override
    public void refresh(final T aReferenceObject) {
        this.manager.refresh(aReferenceObject);
    }
    @Override
    public void refresh(final T aReferenceObject, final LockModeType aLockModeType) {
        this.manager.refresh(aReferenceObject, aLockModeType);
    }
    @Override
    public void lock(final T aReferenceObject, final LockModeType aLockModeType) {
        this.manager.lock(aReferenceObject, aLockModeType);
    }
    @Override
    public void flush() {
        this.manager.flush();
    }
    @Override
    public void detach(final T aReferenceObject) {
        this.manager.detach(aReferenceObject);
    }
    @Override
    public boolean contains(final T aReferenceObject) {
        return this.manager.contains(aReferenceObject);
    }
    @Override
    public CriteriaBuilder builder() {
        return this.manager.getCriteriaBuilder();
    }
    @Override
    public CriteriaQuery<T> query() {
        return builder().createQuery(this.clazz);
    }
    @Override
    public Root<T> root() {
        return query().from(this.clazz);
    }
    @Override
    public TypedQuery<T> createQuery(final CriteriaQuery<T> aQuery) {
        return this.manager.createQuery(aQuery);
    }
}
