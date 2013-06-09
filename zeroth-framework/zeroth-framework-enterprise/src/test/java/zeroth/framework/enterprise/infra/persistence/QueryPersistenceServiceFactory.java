// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.infra.persistence;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import zeroth.framework.enterprise.domain.TestExample;
/**
 * 拡張データ永続化サービスのファクトリ
 * @author nilcy
 */
public class QueryPersistenceServiceFactory {
    /** 基礎エンティティマネージャ */
    @Inject
    @PrimaryEntityManager
    private EntityManager manager;
    /** コンストラクタ */
    public QueryPersistenceServiceFactory() {
    }
    /**
     * テスト参照オブジェクトの拡張データ永続化サービスを作成
     * @return テスト参照オブジェクトの拡張データ永続化サービス
     */
    @Produces
    public QueryPersistenceService<TestExample, Long> createTestExamplePersistenceService() {
        final QueryPersistenceService<TestExample, Long> service = new QueryPersistenceServiceImpl<>(
            manager, TestExample.class);
        // service.setup(manager, TestExample.class);
        return service;
    }
}
