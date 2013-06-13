// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.domain.actor;
import java.util.Collection;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import zeroth.actor.common.TraceLog;
import zeroth.actor.domain.AbstractCrudRepository;
import zeroth.actor.entity.actor.Organ;
import zeroth.actor.infra.persistence.PersistenceSupport;
import zeroth.actor.infra.persistence.actor.OrganPersistence;
/**
 * Organization repository implementation.
 * @author nilcy
 */
@Default
@TraceLog
public class OrganRepositoryImpl extends AbstractCrudRepository<Organ> implements OrganRepository {
    /** S/N. */
    private static final long serialVersionUID = 2537651945740718957L;
    /** organization persistence I/F. */
    @Inject
    private OrganPersistence helper;
    /** Constructor. */
    public OrganRepositoryImpl() {
        super();
    }
    /**
     * {@inheritDoc} Get {@link #helper}.
     * @return {@inheritDoc}
     */
    @Override
    public PersistenceSupport<Organ> getPersistenceSupport() {
        return this.helper;
    }
    @Override
    public Collection<Organ> suggestParents(final Organ aTarget) {
        return this.helper.suggestParents(aTarget);
    }
}
