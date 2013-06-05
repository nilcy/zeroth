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
import javax.persistence.criteria.Root;
import zeroth.framework.enterprise.infra.persistence.PersistenceService;
import zeroth.framework.enterprise.infra.persistence.QueryPersistenceService;
/**
 * テストオブジェクト基本リポジトリ
 * @author nilcy
 */
@Default
public class TestExampleSimpleRepositoryImpl extends
    AbstractSimpleRepositoryImpl<TestExample, Long, TestExampleValue> implements
    TestExampleSimpleRepository {
    /** 製品番号 */
    private static final long serialVersionUID = 5224122483123731291L;
    /** 拡張データ永続化サービス */
    @Inject
    private QueryPersistenceService<TestExample, Long> persistenceService;
    /** {@inheritDoc} */
    @Override
    protected PersistenceService<TestExample, Long> getPersistenceService() {
        return this.persistenceService;
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
    /**
     * クエリの作成
     * @param filter 抽出条件
     * @return クエリ
     */
    private TypedQuery<TestExample> createQuery(final TestExampleValue filter) {
        final CriteriaBuilder b = this.persistenceService.builder();
        final CriteriaQuery<TestExample> q = this.persistenceService.query();
        final Root<TestExample> r = this.persistenceService.root();
        return this.persistenceService.createQuery(q.select(r)
            .where(b.equal(r.get(code), filter.getCode())).orderBy(b.asc(r.get(code)))
            .groupBy(r.get(code)));
    }
}
