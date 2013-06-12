// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.infra.persistence;
import java.io.Serializable;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import zeroth.framework.enterprise.shared.Persistable;
import zeroth.framework.standard.shared.Pageable;
/**
 * 先進データ永続化サービスI/F(JPA2/CriteriaQuery)
 * <p>
 * クエリオブジェクト@PofEAA
 * </p>
 * @param <T> エンティティ型
 * @param <ID> 識別子オブジェクト型
 * @author nilcy
 */
public interface QueryPersistenceService<T extends Persistable<ID>, ID extends Serializable>
    extends SimplePersistenceService<T, ID> {
    /**
     * 標準ビルダーの取得
     * @return 標準ビルダー
     */
    CriteriaBuilder builder();
    /**
     * 標準クエリの取得
     * <p>
     * まずCriteria-APIを使用して標準クエリを設定する。これがクエリの作成で使用される。
     * </p>
     * @return 標準クエリ
     */
    CriteriaQuery<T> query();
    /**
     * 標準ルートの取得
     * @return 標準ルート
     */
    Root<T> root();
    /**
     * クエリの作成
     * @return クエリ
     */
    TypedQuery<T> createQuery();
    /**
     * クエリの作成
     * @param pageable ページ条件I/F
     * @return クエリ
     */
    TypedQuery<T> createQuery(Pageable pageable);
    /**
     * 件数クエリの作成
     * @param expression WHERE句
     * @return 件数クエリ
     */
    TypedQuery<Long> createCountQuery(Predicate expression);
}
