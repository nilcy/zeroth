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
 * @since JPA 2.0
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
    /** {@inheritDoc} */
    @Override
    public CriteriaBuilder builder() {
        return builder;
    }
    /** {@inheritDoc} */
    @Override
    public CriteriaQuery<T> query() {
        return query;
    }
    /** {@inheritDoc} */
    @Override
    public Root<T> root() {
        return root;
    }
    /** {@inheritDoc} */
    @Override
    public TypedQuery<T> createQuery() {
        return manager.createQuery(query);
    }
    /**
     * {@inheritDoc}
     * <p>
     * ページ条件があるとき、オフセット、ページサイズ、ソート条件をクエリへ設定して、範囲指定クエリを作成する。 ページ条件がないとき、クエリを作成する。
     * </p>
     */
    @Override
    public TypedQuery<T> createQuery(final Pageable pageable) {
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
            return createRangeQuery(createQuery(), pageable.getOffset(), pageable.getPageSize());
        }
        return createQuery();
    }
    /**
     * {@inheritDoc}
     * <p>
     * WHERE句がないとき表明エラーとする。標準ルートとWHERE句をもとに件数クエリを作成する。
     * </p>
     */
    @Override
    public TypedQuery<Long> createCountQuery(final Predicate expression) {
        assert expression != null;
        return manager.createQuery(builder().createQuery(Long.class)
            .select(builder().count(root())).where(expression));
    }
}
