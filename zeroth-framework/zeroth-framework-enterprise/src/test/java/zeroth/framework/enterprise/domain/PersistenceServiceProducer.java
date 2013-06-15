// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import zeroth.framework.enterprise.domain.PersistenceServiceAnnotation.TestExamplePersistenceService;
import zeroth.framework.enterprise.infra.persistence.PersistenceServiceFactory;
import zeroth.framework.enterprise.infra.persistence.PrimaryEntityManager;
import zeroth.framework.enterprise.infra.persistence.QueryPersistenceService;
/**
 * 拡張データ永続化サービスのファクトリ
 * @author nilcy
 */
public class PersistenceServiceProducer {
    /** 基礎エンティティマネージャ */
    @Inject
    @PrimaryEntityManager
    private EntityManager manager;
    /** データ永続化サービスのファクトリ */
    @Inject
    private PersistenceServiceFactory factory;
    /** コンストラクタ */
    public PersistenceServiceProducer() {
    }
    /**
     * テスト参照オブジェクトの拡張データ永続化サービスを作成
     * @return テスト参照オブジェクトの拡張データ永続化サービス
     */
    @Produces
    @TestExamplePersistenceService
    public QueryPersistenceService<TestExample, Long> createTestExamplePersistenceService() {
        return factory.createQueryPersistenceService(manager, TestExample.class);
    }
}
