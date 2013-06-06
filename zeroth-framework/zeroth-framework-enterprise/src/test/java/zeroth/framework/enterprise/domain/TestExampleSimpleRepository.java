// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
import static zeroth.framework.enterprise.domain.TestExample_.*;
import java.util.Collection;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import zeroth.framework.enterprise.infra.persistence.PersistenceService;
import zeroth.framework.enterprise.infra.persistence.QueryPersistenceService;
import zeroth.framework.standard.shared.Pageable;
/**
 * テストオブジェクト基本リポジトリ
 * @author nilcy
 */
@Default
public class TestExampleSimpleRepository extends
    AbstractSimpleRepositoryImpl<TestExample, Long, TestExampleValue> {
    /** 製品番号 */
    private static final long serialVersionUID = 5224122483123731291L;
    /** 拡張データ永続化サービス */
    @Inject
    private QueryPersistenceService<TestExample, Long> service;
    /** {@inheritDoc} */
    @Override
    protected PersistenceService<TestExample, Long> getPersistenceService() {
        return service;
    }
    /** {@inheritDoc} */
    @Override
    public TestExample findOne(final TestExampleValue filter) {
        return createQuery(filter).getSingleResult();
    }
    /** {@inheritDoc} */
    @Override
    public Collection<TestExample> findMany(final TestExampleValue filter) {
        return createQuery(filter).getResultList();
    }
    /** {@inheritDoc} */
    @Override
    public long count(final TestExampleValue filter) {
        final CriteriaBuilder b = service.builder();
        final Root<TestExample> r = service.root();
        return service
            .createCountQuery(
                b.createQuery(Long.class).select(b.count(r)).where(expression(b, r, filter)))
            .getSingleResult().longValue();
    }
    /**
     * クエリの作成
     * @param filter 抽出条件
     * @return クエリ
     */
    private TypedQuery<TestExample> createQuery(final TestExampleValue filter) {
        final CriteriaBuilder b = service.builder();
        final Root<TestExample> r = service.root();
        final CriteriaQuery<TestExample> q = service.query();
        q.select(r).where(expression(b, r, filter));
        final Pageable pageable = filter.getPageRequest();
        if (pageable != null) {
            setOrder(b, r, q, pageable);
            return service.createQuery(q, pageable.getOffset(), pageable.getPageSize());
        }
        return service.createQuery(q);
    }
    /**
     * WHERE句の作成
     * @param builder 標準ビルダー
     * @param root 標準ルート
     * @param filter 検索条件
     * @return WHERE句
     */
    private static Predicate expression(final CriteriaBuilder builder,
        final Root<TestExample> root, final TestExampleValue filter) {
        return builder.equal(root.get(code), filter.getCode());
    }
}
