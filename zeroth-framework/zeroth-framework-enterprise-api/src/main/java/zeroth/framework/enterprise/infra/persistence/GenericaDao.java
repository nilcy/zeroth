// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.infra.persistence;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import zeroth.framework.enterprise.domain.ReferenceObject;
import zeroth.framework.enterprise.shared.Service;
/**
 * 基本データ永続化サービスI/F
 * @param <T> 参照オブジェクト型
 * @param <ID> 識別子オブジェクト型
 * @author nilcy
 */
public interface GenericaDao<T extends ReferenceObject<T, ID>, ID> extends Service {
    /**
     * 初期化
     * @param aClass 参照オブジェクトクラス
     * @param aManager 参照オブジェクトマネージャ
     */
    void init(final Class<T> aClass, EntityManager aManager);
    /**
     * 参照オブジェクトの登録
     * @param aReferenceObject 参照オブジェクト
     */
    void create(T aReferenceObject);
    /**
     * 参照オブジェクトの閲覧
     * @param aId 識別子
     * @return 参照オブジェクト
     */
    T read(ID aId);
    /**
     * 参照オブジェクトの閲覧
     * @param aId 識別子
     * @param aLockModeType ロックモードタイプ
     * @return 参照オブジェクト
     */
    T read(Long aId, LockModeType aLockModeType);
    /**
     * 参照オブジェクトの変更
     * @param aReferenceObject 変更後の参照オブジェクト
     */
    void update(T aReferenceObject);
    /**
     * 参照オブジェクトの削除
     * @param aReferenceObject 参照オブジェクト
     */
    void delete(T aReferenceObject);
    /**
     * 参照オブジェクトの更新
     * @param aReferenceObject 参照オブジェクト
     */
    void refresh(final T aReferenceObject);
    /**
     * 参照オブジェクトの更新
     * @param aReferenceObject 参照オブジェクト
     * @param aLockModeType ロックモードタイプ
     */
    void refresh(final T aReferenceObject, final LockModeType aLockModeType);
    /**
     * 参照オブジェクトの保護
     * @param aReferenceObject 参照オブジェクト
     * @param aLockModeType ロックモードタイプ
     */
    void lock(final T aReferenceObject, LockModeType aLockModeType);
    /** 参照オブジェクトの同期 */
    void flush();
    /**
     * 参照オブジェクトの分離
     * @param aReferenceObject 参照オブジェクト
     */
    void detach(T aReferenceObject);
    /**
     * 参照オブジェクト含有の確認
     * @param aReferenceObject 参照オブジェクト
     * @return 含有するとき真。含有しないとき偽。
     */
    boolean contains(final T aReferenceObject);
    /**
     * 標準ビルダーの取得
     * @return 標準ビルダー
     */
    CriteriaBuilder builder();
    /**
     * 標準クエリーの取得
     * @return 標準クエリー
     */
    CriteriaQuery<T> query();
    /**
     * 標準ルートの取得
     * @return 標準ルート
     */
    Root<T> root();
    /**
     * 型付けクエリーの取得
     * @param aQuery 標準クエリー
     * @return 型付けクエリー
     */
    TypedQuery<T> createQuery(CriteriaQuery<T> aQuery);
}
