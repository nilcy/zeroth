// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.infra.persistence;
import java.io.Serializable;
import javax.ejb.Stateful;
import javax.persistence.TypedQuery;
import zeroth.framework.enterprise.domain.Persistable;
/**
 * 標準データ永続化サービス(JPA2/JPQL)
 * <p>
 * {@link SimplePersistenceServiceImpl} へJava標準クエリ(JPQL)を追加したサービスである。
 * </p>
 * @param <E> エンティティ型
 * @param <ID> 識別子オブジェクト型
 * @since JPA 1.0
 * @author nilcy
 */
@Stateful
public class StandardPersistenceServiceImpl<E extends Persistable<ID>, ID extends Serializable>
    extends SimplePersistenceServiceImpl<E, ID> implements StandardPersistenceService<E, ID> {
    /** 識別番号 */
    private static final long serialVersionUID = -1029454631523751121L;
    /** {@inheritDoc} */
    @Override
    public TypedQuery<E> createQuery(final String jpql) {
        return manager.createQuery(jpql, super.clazz);
    }
    /** {@inheritDoc} */
    @Override
    public TypedQuery<E> createNamedQuery(final String queryName) {
        return manager.createNamedQuery(queryName, super.clazz);
    }
}
