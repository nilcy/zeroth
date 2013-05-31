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
import zeroth.framework.standard.shared.Service;
/**
 * 基本データ永続化サービスI/F
 * @param <T> エンティティ型
 * @param <ID> 識別子オブジェクト型
 * @author nilcy
 */
public abstract interface PersistenceService<T extends Persistable<ID>, ID extends Serializable>
    extends Service {
    /**
     * 初期化
     * <p>
     * 本サービスのファクトリから実行すること。
     * </p>
     * @param aClass エンティティクラス
     * @param aManager エンティティマネージャ
     */
    void setup(final Class<T> aClass, EntityManager aManager);
    /**
     * エンティティの登録
     * @param aEntity エンティティ
     */
    void persist(T aEntity);
    /**
     * エンティティの閲覧
     * @param aId 識別子
     * @return エンティティ
     */
    T find(ID aId);
    /**
     * エンティティの閲覧
     * @param aId 識別子
     * @param aLockModeType ロックモードタイプ
     * @return エンティティ
     */
    T find(Long aId, LockModeType aLockModeType);
    /**
     * エンティティの変更
     * @param aEntity 変更後のエンティティ
     */
    void merge(T aEntity);
    /**
     * エンティティの削除
     * @param aEntity エンティティ
     */
    void remove(T aEntity);
    /**
     * エンティティの更新
     * @param aEntity エンティティ
     */
    void refresh(final T aEntity);
    /**
     * エンティティの更新
     * @param aEntity エンティティ
     * @param aLockModeType ロックモードタイプ
     */
    void refresh(final T aEntity, final LockModeType aLockModeType);
    /**
     * エンティティの保護
     * @param aEntity エンティティ
     * @param aLockModeType ロックモードタイプ
     */
    void lock(final T aEntity, LockModeType aLockModeType);
    /** エンティティの同期 */
    void flush();
    /**
     * エンティティの分離
     * @param aEntity エンティティ
     */
    void detach(T aEntity);
    /**
     * エンティティ含有の確認
     * @param aEntity エンティティ
     * @return 含有するとき真。含有しないとき偽。
     */
    boolean contains(final T aEntity);
}
