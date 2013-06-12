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
import zeroth.framework.standard.shared.ValueObject;
/**
 * 基本リポジトリI/F
 * @param <E> エンティティ型
 * @param <ID> 識別子オブジェクト型
 * @param <F> 検索条件オブジェクト型
 * @author nilcy
 */
public interface SimpleRepository<E extends Persistable<ID>, ID extends Serializable, F extends ValueObject<?>>
    extends Repository {
    /**
     * エンティティ保存
     * @param entity エンティティ
     * @return エンティティ
     * @throws ConstraintsException 制約違反キャッチ例外
     */
    E save(E entity) throws ConstraintsException;
    /**
     * エンティティ削除
     * @param entity エンティティ
     * @throws ConstraintsException 制約違反キャッチ例外
     */
    void delete(E entity) throws ConstraintsException;
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
}
