// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.infra.persistence;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import zeroth.framework.standard.domain.ReferenceObject;
/**
 * 汎用データ操作
 * @param <T> 参照オブジェクト型
 * @param <ID> 識別子オブジェクト型
 * @author nilcy
 */
public abstract class AbstractPersistenceServiceImpl<T extends ReferenceObject<T, ID>, ID> implements
    PersistenceService<T, ID> {
    /** 識別番号 */
    private static final long serialVersionUID = -2663309706616831662L;
    /** 参照オブジェクトクラス */
    protected Class<T> clazz;
    /** 参照オブジェクトマネージャ */
    protected EntityManager manager;
    /** コンストラクタ */
    public AbstractPersistenceServiceImpl() {
    }
    @Override
    public void setup(final Class<T> aClass, final EntityManager aManager) {
        this.clazz = aClass;
        this.manager = aManager;
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
}
