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
     * @param clazz エンティティクラス
     * @param manager エンティティマネージャ
     */
    void setup(final Class<T> clazz, EntityManager manager);
    /**
     * エンティティの登録
     * @param entity エンティティ
     */
    void persist(T entity);
    /**
     * エンティティのID検索
     * @param id 識別子
     * @return エンティティ
     */
    T find(ID id);
    /**
     * エンティティのID検索
     * @param id 識別子
     * @param lockModeType ロックモードタイプ
     * @return エンティティ
     */
    T find(Long id, LockModeType lockModeType);
    /**
     * エンティティの変更
     * @param entity 変更後のエンティティ
     */
    void merge(T entity);
    /**
     * エンティティの削除
     * @param entity エンティティ
     */
    void remove(T entity);
    /**
     * エンティティの更新
     * @param entity エンティティ
     */
    void refresh(final T entity);
    /**
     * エンティティの更新
     * @param entity エンティティ
     * @param lockModeType ロックモードタイプ
     */
    void refresh(final T entity, final LockModeType lockModeType);
    /**
     * エンティティの保護
     * @param entity エンティティ
     * @param lockModeType ロックモードタイプ
     */
    void lock(final T entity, LockModeType lockModeType);
    /** エンティティの同期 */
    void flush();
    /**
     * エンティティの分離
     * @param entity エンティティ
     */
    void detach(T entity);
    /**
     * エンティティ含有の確認
     * @param entity エンティティ
     * @return 含有するとき真。含有しないとき偽。
     */
    boolean contains(final T entity);
    /**
     * クエリ結果範囲の設定
     * @param query クエリ
     * @param begin 開始位置
     * @param max 最大件数
     * @return クエリ
     */
    TypedQuery<T> setRange(final TypedQuery<T> query, final int begin, final int max);
    /**
     * エンティティのクエリ検索
     * @param query クエリ
     * @return 複数エンティティ
     */
    Collection<T> findMany(TypedQuery<T> query);
    /**
     * エンティティのクエリ検索
     * @param query クエリ
     * @return 単一エンティティ
     */
    T findOne(TypedQuery<T> query);
}
