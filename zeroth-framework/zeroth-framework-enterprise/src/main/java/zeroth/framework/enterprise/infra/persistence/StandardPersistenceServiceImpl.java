// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.infra.persistence;
import java.io.Serializable;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.persistence.TypedQuery;
import zeroth.framework.enterprise.domain.Persistable;
/**
 * 標準データ永続化サービス(JPA2/JPQL)
 * @param <E> エンティティ型
 * @param <ID> 識別子オブジェクト型
 * @author nilcy
 */
@Stateless
@Alternative
public class StandardPersistenceServiceImpl<E extends Persistable<ID>, ID extends Serializable>
    extends AbstractPersistenceServiceImpl<E, ID> implements StandardPersistenceService<E, ID> {
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
