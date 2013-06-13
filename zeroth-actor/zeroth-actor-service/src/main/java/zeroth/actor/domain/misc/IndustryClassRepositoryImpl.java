// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.domain.misc;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import zeroth.actor.common.TraceLog;
import zeroth.actor.domain.AbstractCrudRepository;
import zeroth.actor.entity.misc.IndustryClass;
import zeroth.actor.infra.persistence.PersistenceSupport;
import zeroth.actor.infra.persistence.misc.IndustryClassPersistence;
/**
 * Industry classification repository implementation.
 * @author nilcy
 */
@Default
@TraceLog
public class IndustryClassRepositoryImpl extends AbstractCrudRepository<IndustryClass> implements
    IndustryClassRepository {
    /** S/N. */
    private static final long serialVersionUID = 2537651945740718957L;
    /** industry classification persistence I/F. */
    @Inject
    private IndustryClassPersistence helper;
    /** Constructor. */
    public IndustryClassRepositoryImpl() {
        super();
    }
    /**
     * {@inheritDoc} Get {@link #helper}.
     * @return {@inheritDoc}
     */
    @Override
    public PersistenceSupport<IndustryClass> getPersistenceSupport() {
        return this.helper;
    }
}
