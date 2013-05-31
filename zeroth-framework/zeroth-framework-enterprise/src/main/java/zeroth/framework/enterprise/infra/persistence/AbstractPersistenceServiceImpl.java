// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.infra.persistence;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import zeroth.framework.standard.domain.Persistable;
/**
 * 汎用データ操作
 * @param <T> エンティティ型
 * @param <ID> 識別子オブジェクト型
 * @author nilcy
 */
public abstract class AbstractPersistenceServiceImpl<T extends Persistable<ID>, ID extends Serializable>
    implements PersistenceService<T, ID> {
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
    public void persist(final T aReferenceObject) {
        this.manager.persist(aReferenceObject);
        flush();
    }
    @Override
    public T find(final ID aId) {
        return this.manager.find(this.clazz, aId);
    }
    @Override
    public T find(final Long aId, final LockModeType aLockModeType) {
        return this.manager.find(this.clazz, aId, aLockModeType);
    }
    @Override
    public void merge(final T aReferenceObject) {
        this.manager.merge(aReferenceObject);
        flush();
    }
    @Override
    public void remove(final T aReferenceObject) {
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
