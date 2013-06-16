// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.domain;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import zeroth.actor.service.domain.Customer;
import zeroth.actor.service.domain.Level;
import zeroth.actor.service.domain.Member;
import zeroth.actor.service.domain.Organ;
import zeroth.actor.service.domain.Partner;
import zeroth.actor.service.domain.Supplier;
import zeroth.actor.service.domain.Title;
import zeroth.actor.service.domain.PersistenceServiceAnnotation.CustomerPersistenceService;
import zeroth.actor.service.domain.PersistenceServiceAnnotation.LevelPersistenceService;
import zeroth.actor.service.domain.PersistenceServiceAnnotation.MemberPersistenceService;
import zeroth.actor.service.domain.PersistenceServiceAnnotation.OrganPersistenceService;
import zeroth.actor.service.domain.PersistenceServiceAnnotation.PartnerPersistenceService;
import zeroth.actor.service.domain.PersistenceServiceAnnotation.SupplierPersistenceService;
import zeroth.actor.service.domain.PersistenceServiceAnnotation.TitlePersistenceService;
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
     * 得意先の先進データ永続化サービスを作成
     * @return 得意先の先進データ永続化サービス
     */
    @Produces
    @CustomerPersistenceService
    public QueryPersistenceService<Customer, Long> createCustomerPersistenceService() {
        return factory.createQueryPersistenceService(manager, Customer.class);
    }
    /**
     * 職級の先進データ永続化サービスを作成
     * @return 職級の先進データ永続化サービス
     */
    @Produces
    @LevelPersistenceService
    public QueryPersistenceService<Level, Long> createLevelPersistenceService() {
        return factory.createQueryPersistenceService(manager, Level.class);
    }
    /**
     * 社員の先進データ永続化サービスを作成
     * @return 社員の先進データ永続化サービス
     */
    @Produces
    @MemberPersistenceService
    public QueryPersistenceService<Member, Long> createMemberPersistenceService() {
        return factory.createQueryPersistenceService(manager, Member.class);
    }
    /**
     * 組織の先進データ永続化サービスを作成
     * @return 組織の先進データ永続化サービス
     */
    @Produces
    @OrganPersistenceService
    public QueryPersistenceService<Organ, Long> createOrganPersistenceService() {
        return factory.createQueryPersistenceService(manager, Organ.class);
    }
    /**
     * 外注の先進データ永続化サービスを作成
     * @return 外注の先進データ永続化サービス
     */
    @Produces
    @PartnerPersistenceService
    public QueryPersistenceService<Partner, Long> createPartnerPersistenceService() {
        return factory.createQueryPersistenceService(manager, Partner.class);
    }
    /**
     * 調達先の先進データ永続化サービスを作成
     * @return 調達先の先進データ永続化サービス
     */
    @Produces
    @SupplierPersistenceService
    public QueryPersistenceService<Supplier, Long> createSupplierPersistenceService() {
        return factory.createQueryPersistenceService(manager, Supplier.class);
    }
    /**
     * 職名の先進データ永続化サービスを作成
     * @return 職名の先進データ永続化サービス
     */
    @Produces
    @TitlePersistenceService
    public QueryPersistenceService<Title, Long> createTitlePersistenceService() {
        return factory.createQueryPersistenceService(manager, Title.class);
    }
}