// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.domain;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import zeroth.actor.common.TraceLog;
import zeroth.actor.domain.AbstractCrudRepository;
import zeroth.actor.entity.actor.Partner;
import zeroth.actor.infra.persistence.PersistenceSupport;
import zeroth.actor.infra.persistence.actor.PartnerPersistence;
/**
 * Partner repository implementation.
 * @author nilcy
 */
@Default
@TraceLog
public class PartnerRepositoryImpl extends AbstractCrudRepository<Partner> implements
    PartnerRepository {
    /** 製品番号 */
    private static final long serialVersionUID = 3003296026718089910L;
    /** partner persistence I/F. */
    @Inject
    private PartnerPersistence helper;
    /** コンストラクタ */
    public PartnerRepositoryImpl() {
        super();
    }
    /**
     * {@inheritDoc} Get {@link #helper}.
     * @return {@inheritDoc}
     */
    @Override
    public PersistenceSupport<Partner> getPersistenceSupport() {
        return this.helper;
    }
}
