// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.infra.persistence;
import javax.ejb.Local;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import zeroth.framework.standard.domain.ReferenceObject;
/**
 * 拡張データ永続化サービスI/F(JPA2/CriteriaQuery)
 * <p>
 * クエリオブジェクト@PofEAA
 * </p>
 * @param <T> 参照オブジェクト型
 * @param <ID> 識別子オブジェクト型
 * @author nilcy
 */
@Local
public interface QueryPersistenceService<T extends ReferenceObject<T, ID>, ID> extends
    PersistenceService<T, ID> {
    /**
     * 標準ビルダーの取得
     * @return 標準ビルダー
     */
    CriteriaBuilder builder();
    /**
     * 標準クエリの取得
     * @return 標準クエリ
     */
    CriteriaQuery<T> query();
    /**
     * 標準ルートの取得
     * @return 標準ルート
     */
    Root<T> root();
    /**
     * クエリの取得
     * @param aQuery 標準クエリ
     * @return クエリ
     */
    TypedQuery<T> createQuery(CriteriaQuery<T> aQuery);
}
