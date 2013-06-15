// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.app.actor;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import zeroth.actor.app.AbstractCrudService;
import zeroth.actor.common.TraceLog;
import zeroth.actor.domain.PartnerRepository;
import zeroth.actor.domain.Repository;
import zeroth.actor.entity.actor.Partner;
/**
 * Partner service implementation.
 * @author nilcy
 */
@Stateless
@Default
@TraceLog
public class PartnerServiceImpl extends AbstractCrudService<Partner> implements PartnerServiceLocal {
    /** 製品番号 */
    private static final long serialVersionUID = -3688733534957646527L;
    /** partner repository I/F. */
    @Inject
    private PartnerRepository repository;
    /** コンストラクタ */
    public PartnerServiceImpl() {
        super();
    }
    /**
     * {@inheritDoc} Get {@link #repository}.
     */
    @Override
    protected Repository<Partner> getRepository() {
        return this.repository;
    }
}
