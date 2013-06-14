// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.infra.persistence;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.LockModeType;
import javax.persistence.TypedQuery;
import zeroth.framework.enterprise.shared.Persistable;
import zeroth.framework.standard.shared.Service;
/**
 * 基本データ永続化サービスI/F
 * <ul>
 * エンティティのライフサイクル
 * <li>New(新規)…インスタンス化しただけの状態。[persist()でManaged化]</li>
 * <li>Managed(管理)…永続コンテキスト中で管理している状態。[find()が可能]</li>
 * <li>Removed(削除)…永続コンテキスト中で削除を予約している状態。[remove()した後]</li>
 * <li>Detached(分離)…永続コンテキストから分離した状態。[merge()でManaged化]</li>
 * </ul>
 * @param <E> エンティティ型
 * @param <ID> 識別子オブジェクト型
 * @author nilcy
 */
public interface SimplePersistenceService<E extends Persistable<ID>, ID extends Serializable>
    extends Service {
    /**
     * 管理エンティティの永続化
     * <p>
     * エンティティ状態の遷移は「新規→管理、削除→管理、管理→(無視)」となる。分離のとき EntityExistsException 例外を発生する。
     * </p>
     * @param entity エンティティ
     */
    void persist(E entity);
    /**
     * 管理エンティティのID検索
     * @param id 識別子
     * @return 管理エンティティ
     */
    E find(ID id);
    /**
     * 管理エンティティのID検索
     * @param id 識別子
     * @param lockModeType ロックモードタイプ
     * @return 管理エンティティ
     */
    E find(ID id, LockModeType lockModeType);
    /**
     * 分離エンティティの永続化
     * <p>
     * エンティティ状態の遷移は「新規→管理、管理→(無視)、分離→管理」となる。削除のとき IllegalArgumentException 例外を発生する。
     * </p>
     * @param entity 分離エンティティ
     * @return 管理エンティティ
     */
    E merge(E entity);
    /**
     * 管理エンティティの削除
     * <p>
     * エンティティ状態の遷移は「新規→(無視)、管理→削除、削除→(無視)」となる。分離のとき IllegalArgumentException 例外を発生する。
     * </p>
     * @param entity 管理エンティティ
     */
    void remove(E entity);
    /**
     * 管理エンティティの更新
     * @param entity 管理エンティティ
     */
    void refresh(final E entity);
    /**
     * 管理エンティティの更新
     * @param entity 管理エンティティ
     * @param lockModeType 保護モード
     */
    void refresh(final E entity, final LockModeType lockModeType);
    /**
     * 管理エンティティの保護
     * @param entity 管理エンティティ
     * @param lockModeType 保護モード
     */
    void lock(final E entity, LockModeType lockModeType);
    /** 管理エンティティのDB反映 */
    void flush();
    /**
     * 管理エンティティの分離
     * @param entity 管理エンティティ
     */
    void detach(E entity);
    /**
     * 管理エンティティ含有の確認
     * @param entity エンティティ
     * @return 含有するとき真。含有しないとき偽。
     */
    boolean contains(final E entity);
    /**
     * 範囲指定クエリの作成
     * @param query クエリ
     * @param offset 開始位置
     * @param maxsize 最大件数
     * @return クエリ
     */
    TypedQuery<E> createRangeQuery(final TypedQuery<E> query, final int offset, final int maxsize);
    /**
     * 管理エンティティ集合のクエリ検索
     * @param query クエリ
     * @return 管理エンティティ集合
     */
    Collection<E> findMany(TypedQuery<E> query);
    /**
     * 管理エンティティのクエリ検索
     * @param query クエリ
     * @return 管理エンティティ
     */
    E findOne(TypedQuery<E> query);
}
