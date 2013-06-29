// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
import java.io.Serializable;
import java.util.Collection;
import zeroth.framework.enterprise.shared.Persistable;
import zeroth.framework.standard.domain.Repository;
/**
 * 基本リポジトリI/F
 * @param <E> エンティティ型
 * @param <ID> 識別子オブジェクト型
 * @param <F> 検索条件オブジェクト型 TODO extends ValueObject<?>
 * @author nilcy
 */
public interface SimpleRepository<E extends Persistable<ID>, ID extends Serializable, F extends Serializable>
    extends Repository {
    /**
     * エンティティ保存
     * @param entity エンティティ
     * @return エンティティ
     * @throws ConstraintsException 制約違反キャッチ例外
     */
    <S extends E> S save(S entity) throws ConstraintsException;
    /**
     * エンティティ保存と反映
     * @param entity エンティティ
     * @return エンティティ
     * @throws ConstraintsException 制約違反キャッチ例外
     */
    <S extends E> S saveAndFlush(S entity) throws ConstraintsException;
    /**
     * エンティティ一括保存
     * @param entities エンティティ集合
     * @return エンティティ集合
     * @throws ConstraintsException 制約違反キャッチ例外
     */
    <S extends E> Collection<S> save(Iterable<S> entities) throws ConstraintsException;
    /**
     * エンティティ削除
     * @param id 識別子
     * @throws ConstraintsException 制約違反キャッチ例外
     */
    void delete(ID id) throws ConstraintsException;
    /**
     * エンティティ削除
     * @param entity エンティティ
     * @throws ConstraintsException 制約違反キャッチ例外
     */
    <S extends E> void delete(S entity) throws ConstraintsException;
    /**
     * エンティティ一括削除
     * @param entities エンティティ集合
     * @throws ConstraintsException 制約違反キャッチ例外
     */
    <S extends E> void delete(Iterable<S> entities) throws ConstraintsException;
    /** エンティティ反映 */
    void flush();
    /**
     * エンティティ検索
     * @param id 識別子
     * @return エンティティ
     */
    E find(ID id);
    /**
     * 単一エンティティ検索
     * <p>
     * 一意制約(UK)をもとにした検索などに使用すること。
     * </p>
     * @param filter 検索条件
     * @return エンティティ(該当オブジェクトがないときNULL)
     */
    E findOne(F filter);
    /**
     * 複数エンティティ検索
     * @param filter 検索条件
     * @return 複数エンティティ(該当オブジェクトがないとき空集合)
     */
    Collection<E> findMany(F filter);
    /**
     * エンティティ件数
     * @param filter 検索条件
     * @return 件数
     */
    long count(F filter);
    /**
     * 管理エンティティ有無の確認
     * @param entity エンティティ
     * @return あるとき真。ないとき偽。
     */
    <S extends E> boolean exists(final S entity);
}
