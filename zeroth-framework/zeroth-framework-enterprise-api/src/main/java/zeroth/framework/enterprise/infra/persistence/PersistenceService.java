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
 * <ul>
 * エンティティのライフサイクル
 * <li>New(新規)…インスタンス化しただけでDBへ反映していない状態。[persist()でManaged化]</li>
 * <li>Managed(管理)…永続コンテキスト中で管理している状態。[find()が可能]</li>
 * <li>Removed(削除)…永続コンテキスト中で削除を予約している状態。[remove()した後]</li>
 * <li>Detached(分離)…永続コンテキストから分離した状態。[merge()でManaged化]</li>
 * </ul>
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
     * 管理エンティティの保存
     * @param entity 新規エンティティ
     */
    void persist(T entity);
    /**
     * 管理エンティティのID検索
     * @param id 識別子
     * @return 管理エンティティ
     */
    T find(ID id);
    /**
     * 管理エンティティのID検索
     * @param id 識別子
     * @param lockModeType ロックモードタイプ
     * @return 管理エンティティ
     */
    T find(Long id, LockModeType lockModeType);
    /**
     * 分離エンティティの保存
     * <p>
     * Detached(分離)からManaged(管理)への復帰
     * </p>
     * @param entity 分離エンティティ
     */
    void merge(T entity);
    /**
     * 管理エンティティの削除
     * @param entity 管理エンティティ
     */
    void remove(T entity);
    /**
     * 管理エンティティの更新
     * @param entity 管理エンティティ
     */
    void refresh(final T entity);
    /**
     * 管理エンティティの更新
     * @param entity 管理エンティティ
     * @param lockModeType 保護モード
     */
    void refresh(final T entity, final LockModeType lockModeType);
    /**
     * 管理エンティティの保護
     * @param entity 管理エンティティ
     * @param lockModeType 保護モード
     */
    void lock(final T entity, LockModeType lockModeType);
    /** 管理エンティティのDB反映 */
    void flush();
    /**
     * 管理エンティティの分離
     * @param entity 管理エンティティ
     */
    void detach(T entity);
    /**
     * 管理エンティティ含有の確認
     * @param entity エンティティ
     * @return 含有するとき真。含有しないとき偽。
     */
    boolean contains(final T entity);
    /**
     * 範囲指定クエリの作成
     * @param query クエリ
     * @param offset 開始位置
     * @param maxsize 最大件数
     * @return クエリ
     */
    TypedQuery<T> createRangeQuery(final TypedQuery<T> query, final int offset, final int maxsize);
    /**
     * 管理エンティティ集合のクエリ検索
     * @param query クエリ
     * @return 管理エンティティ集合
     */
    Collection<T> findMany(TypedQuery<T> query);
    /**
     * 管理エンティティのクエリ検索
     * @param query クエリ
     * @return 管理エンティティ
     */
    T findOne(TypedQuery<T> query);
}
