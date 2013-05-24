// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.infra.persistence;
import javax.ejb.EJB;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import zeroth.framework.enterprise.domain.TestExample;
/**
 * 汎用データ操作プロデューサ
 * @author nilcy
 */
public class QueryPersistenceServiceFactory {
    /** 参照オブジェクトマネージャ */
    @Inject
    @PrimaryEntityManager
    private EntityManager manager;
    /** テスト用のサンプルオブジェクトDAO */
    @EJB
    private QueryPersistenceService<TestExample, Long> testExampleObjectPersistenceService;
    /** コンストラクタ */
    public QueryPersistenceServiceFactory() {
    }
    /**
     * {@link #testExampleObjectPersistenceService} の作成
     * @return {@link #testExampleObjectPersistenceService}
     */
    @Produces
    public QueryPersistenceService<TestExample, Long> createTestExampleObjectPersistenceService() {
        this.testExampleObjectPersistenceService.init(TestExample.class, this.manager);
        return this.testExampleObjectPersistenceService;
    }
}
