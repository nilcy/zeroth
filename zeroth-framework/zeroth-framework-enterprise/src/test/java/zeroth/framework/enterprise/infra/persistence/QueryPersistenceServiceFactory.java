// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.infra.persistence;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
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
    /** データ永続化サービスのファクトリ */
    @Inject
    private PersistenceServiceFactory factory;
    /** コンストラクタ */
    public QueryPersistenceServiceFactory() {
    }
    /**
     * テスト参照オブジェクトの拡張データ永続化サービスを作成
     * @return テスト参照オブジェクトの拡張データ永続化サービス
     */
    @Produces
    @Named("TestExamplePersistenceService")
    public QueryPersistenceService<TestExample, Long> createTestExamplePersistenceService() {
        return factory.createQueryPersistenceService(manager, TestExample.class);
    }
}
