// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.infra.persistence;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import zeroth.framework.enterprise.domain.Persistable;
import zeroth.framework.standard.shared.Pageable;
import zeroth.framework.standard.shared.Sort.Direction;
import zeroth.framework.standard.shared.Sort.Order;
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
    /** 標準ビルダー */
    private CriteriaBuilder builder;
    /** 標準クエリ */
    public CriteriaQuery<T> query;
    /** 標準ルート */
    public Root<T> root;
    /**
     * {@inheritDoc}
     * <p>
     * 標準ビルダー、標準クエリ、標準ルートを設定する。
     * </p>
     */
    @Override
    public void setup(final Class<T> clazz, final EntityManager manager) {
        super.setup(clazz, manager);
        builder = manager.getCriteriaBuilder();
        query = builder().createQuery(clazz);
        root = query().from(clazz);
    }
    @Override
    public CriteriaBuilder builder() {
        return builder;
    }
    @Override
    public CriteriaQuery<T> query() {
        return query;
    }
    @Override
    public Root<T> root() {
        return root;
    }
    @Override
    public TypedQuery<T> createQuery(final CriteriaQuery<T> query) {
        assert query != null;
        return manager.createQuery(query);
    }
    /** {@inheritDoc} */
    @Override
    public TypedQuery<T> createQuery(final CriteriaQuery<T> query, final Pageable pageable) {
        final CriteriaBuilder builder = builder();
        final Root<T> root = root();
        if (pageable != null) {
            if (pageable.getSort() != null) {
                final Collection<javax.persistence.criteria.Order> criteriaOrders = new ArrayList<>();
                for (final Iterator<Order> iter = pageable.getSort().iterator(); iter.hasNext();) {
                    final Order order = iter.next();
                    if (Direction.ASC.equals(order.getDirection())) {
                        criteriaOrders.add(builder.asc(root.get(order.getProperty())));
                    } else {
                        criteriaOrders.add(builder.desc(root.get(order.getProperty())));
                    }
                }
                query.orderBy(criteriaOrders.toArray(new javax.persistence.criteria.Order[0]));
            }
            return createQuery(query).setFirstResult(pageable.getOffset()).setMaxResults(
                pageable.getPageSize());
        }
        return createQuery(query);
    }
    /** {@inheritDoc} */
    @Override
    public TypedQuery<Long> createCountQuery(final Predicate expression) {
        assert expression != null;
        return manager.createQuery(builder().createQuery(Long.class)
            .select(builder().count(root())).where(expression));
    }
}
