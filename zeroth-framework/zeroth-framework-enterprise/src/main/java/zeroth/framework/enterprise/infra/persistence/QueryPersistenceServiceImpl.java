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
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import zeroth.framework.enterprise.domain.Persistable;
/**
 * 拡張データ永続化サービス(JPA2/CriteriaQuery)
 * <p>
 * クエリオブジェクト@PofEAA
 * </p>
 * @param <T> エンティティ型
 * @param <ID> 識別子オブジェクト型
 * @author nilcy
 */
@Stateless
@Alternative
public class QueryPersistenceServiceImpl<T extends Persistable<ID>, ID extends Serializable>
    extends AbstractPersistenceServiceImpl<T, ID> implements QueryPersistenceService<T, ID> {
    /** 識別番号 */
    private static final long serialVersionUID = 6451157743975586409L;
    @Override
    public CriteriaBuilder builder() {
        return this.manager.getCriteriaBuilder();
    }
    @Override
    public CriteriaQuery<T> query() {
        return builder().createQuery(this.clazz);
    }
    @Override
    public Root<T> root() {
        return query().from(this.clazz);
    }
    @Override
    public TypedQuery<T> createQuery(final CriteriaQuery<T> aQuery) {
        return this.manager.createQuery(aQuery);
    }
}
