// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
import java.io.Serializable;
import java.util.Collection;
import zeroth.framework.standard.domain.Repository;
/**
 * 基本リポジトリI/F
 * @param <E> エンティティ型
 * @param <ID> 識別子オブジェクト型
 * @param <F> フィルタ型
 * @author nilcy
 */
public interface SimpleRepository<E extends Persistable<ID>, ID extends Serializable, F extends Object>
    extends Repository {
    /**
     * エンティティ保存
     * @param entity エンティティ
     */
    void save(E entity);
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
     * <p>
     * フィルタ条件などをもとにした検索などに使用すること。
     * </p>
     * @param filter 検索条件
     * @return エンティティ集合(該当オブジェクトがないとき空集合)
     */
    Collection<E> findMany(F filter);
    /**
     * エンティティ削除
     * @param entity エンティティ
     */
    void delete(E entity);
}
