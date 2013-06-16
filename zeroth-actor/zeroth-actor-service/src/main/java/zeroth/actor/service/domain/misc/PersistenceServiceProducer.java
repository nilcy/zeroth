// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.domain.misc;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import zeroth.actor.service.domain.misc.PersistenceServiceAnnotation.IndustryClassPersistenceService;
import zeroth.actor.service.domain.misc.PersistenceServiceAnnotation.ListedSectionPersistenceService;
import zeroth.actor.service.domain.misc.PersistenceServiceAnnotation.NewsPersistenceService;
import zeroth.framework.enterprise.infra.persistence.PersistenceServiceFactory;
import zeroth.framework.enterprise.infra.persistence.PrimaryEntityManager;
import zeroth.framework.enterprise.infra.persistence.QueryPersistenceService;
/**
 * データ永続化サービスのファクトリ
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
     * 業種の先進データ永続化サービスを作成
     * @return お知らせの先進データ永続化サービス
     */
    @Produces
    @IndustryClassPersistenceService
    public QueryPersistenceService<IndustryClass, Long> createIndustryClassPersistenceService() {
        return factory.createQueryPersistenceService(manager, IndustryClass.class);
    }
    /**
     * 上場先の先進データ永続化サービスを作成
     * @return 上場先の先進データ永続化サービス
     */
    @Produces
    @ListedSectionPersistenceService
    public QueryPersistenceService<ListedSection, Long> createListedSectionPersistenceService() {
        return factory.createQueryPersistenceService(manager, ListedSection.class);
    }
    // /**
    // * 告知の先進データ永続化サービスを作成
    // * @return 告知の先進データ永続化サービス
    // */
    // @SuppressWarnings("unchecked")
    // @Produces
    // @NoticePersistenceService
    // public QueryPersistenceService<? extends Notice<?>, Long> createNoticePersistenceService() {
    // return factory.createQueryPersistenceService(manager, Notice.class);
    // }
    /**
     * お知らせの先進データ永続化サービスを作成
     * @return お知らせの先進データ永続化サービス
     */
    @SuppressWarnings("unchecked")
    @Produces
    @NewsPersistenceService
    public QueryPersistenceService<News, Long> createNewsPersistenceService() {
        return factory.createQueryPersistenceService(manager, Notice.class);
    }
}
