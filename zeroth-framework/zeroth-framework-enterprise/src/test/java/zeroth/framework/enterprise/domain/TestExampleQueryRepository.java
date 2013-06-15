// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
import static zeroth.framework.enterprise.domain.TestExample_.*;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.criteria.Predicate;
import zeroth.framework.enterprise.domain.PersistenceServiceAnnotation.TestExamplePersistenceService;
import zeroth.framework.enterprise.infra.persistence.QueryPersistenceService;
/**
 * テストオブジェクト基本リポジトリ
 * @author nilcy
 */
@Default
public class TestExampleQueryRepository extends
    AbstractQueryRepositoryImpl<TestExample, Long, TestExampleValue> {
    /** 製品番号 */
    private static final long serialVersionUID = 5224122483123731291L;
    /** 拡張データ永続化サービス */
    @Inject
    @TestExamplePersistenceService
    private QueryPersistenceService<TestExample, Long> service;
    /** {@inheritDoc} */
    @Override
    protected QueryPersistenceService<TestExample, Long> getPersistenceService() {
        return service;
    }
    /**
     * {@inheritDoc}
     * <p>
     * 検索条件は、コードとする。
     * </p>
     */
    @Override
    protected Predicate expression(final TestExampleValue filter) {
        return getPersistenceService().builder().equal(getPersistenceService().root().get(code),
            filter.getCode());
    }
}
