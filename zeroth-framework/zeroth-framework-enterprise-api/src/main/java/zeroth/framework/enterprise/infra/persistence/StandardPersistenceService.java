// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.infra.persistence;
import javax.ejb.Local;
import javax.persistence.TypedQuery;
import zeroth.framework.enterprise.domain.ReferenceObject;
/**
 * 標準データ永続化サービスI/F(JPA2/JPQL)
 * @param <T> 参照オブジェクト型
 * @param <ID> 識別子オブジェクト型
 * @author nilcy
 */
@Local
public interface StandardPersistenceService<T extends ReferenceObject<T, ID>, ID> extends
    PersistenceService<T, ID> {
    /**
     * クエリの作成
     * @param aJPQL JPQL
     * @return クエリ
     */
    public TypedQuery<T> createQuery(final String aJPQL);
    /**
     * クエリの作成
     * @param aQueryName クエリ名
     * @return クエリ
     */
    public TypedQuery<T> createNamedQuery(final String aQueryName);
}
