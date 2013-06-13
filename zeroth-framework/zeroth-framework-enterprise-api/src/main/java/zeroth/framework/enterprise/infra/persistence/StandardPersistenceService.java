// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.infra.persistence;
import java.io.Serializable;
import javax.persistence.TypedQuery;
import zeroth.framework.enterprise.shared.Persistable;
/**
 * 標準データ永続化サービスI/F(JPA2/JPQL)
 * @param <E> エンティティ型
 * @param <ID> 識別子オブジェクト型
 * @author nilcy
 */
public interface StandardPersistenceService<E extends Persistable<ID>, ID extends Serializable>
    extends SimplePersistenceService<E, ID> {
    /**
     * クエリの作成
     * @param jpql JPQL
     * @return クエリ
     */
    TypedQuery<E> createQuery(final String jpql);
    /**
     * クエリの作成
     * @param queryName クエリ名
     * @return クエリ
     */
    TypedQuery<E> createNamedQuery(final String queryName);
}
