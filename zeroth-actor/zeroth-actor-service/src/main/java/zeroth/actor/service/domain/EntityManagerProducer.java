// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.domain;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import zeroth.framework.enterprise.infra.persistence.PrimaryEntityManager;
/**
 * エンティティマネージャのファクトリ
 * @author nilcy
 */
public final class EntityManagerProducer {
    /** 基礎エンティティマネージャ */
    @Produces
    @PrimaryEntityManager
    @PersistenceContext(unitName = "primary")
    private EntityManager primaryEntityManager;
    // /** 補助エンティティマネージャ */
    // @Produces
    // @SecondaryEntityManager
    // @PersistenceContext(unitName = "secondary")
    // private EntityManager secondaryEntityManager;
    /** コンストラクタ */
    public EntityManagerProducer() {
    }
}
