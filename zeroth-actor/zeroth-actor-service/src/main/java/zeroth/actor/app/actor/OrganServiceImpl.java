// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.app.actor;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import zeroth.actor.app.AbstractCrudService;
import zeroth.actor.common.TraceLog;
import zeroth.actor.domain.OrganRepository;
import zeroth.actor.domain.Repository;
import zeroth.actor.entity.actor.Organ;
/**
 * Organization service implementation.
 * @author nilcy
 */
@Stateless
@Default
@TraceLog
public class OrganServiceImpl extends AbstractCrudService<Organ> implements OrganServiceLocal {
    /** 製品番号 */
    private static final long serialVersionUID = 2537651945740718957L;
    /** organization repository I/F. */
    @Inject
    private OrganRepository repository;
    /** コンストラクタ */
    public OrganServiceImpl() {
        super();
    }
    /**
     * {@inheritDoc} Get {@link #repository}.
     */
    @Override
    protected Repository<Organ> getRepository() {
        return this.repository;
    }
    @Override
    public Collection<Organ> suggestParents(final Organ aTarget) {
        return suggestParents(aTarget);
    }
}
