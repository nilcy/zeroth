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
import zeroth.actor.entity.misc.ListedSection;
import zeroth.actor.infra.persistence.PersistenceSupport;
import zeroth.actor.infra.persistence.misc.ListedSectionPersistence;
/**
 * Listed section repository implementation.
 * @author nilcy
 */
@Default
@TraceLog
public class ListedSectionRepositoryImpl extends AbstractCrudRepository<ListedSection> implements
    ListedSectionRepository {
    /** S/N. */
    private static final long serialVersionUID = 2537651945740718957L;
    /** organization persistence I/F. */
    @Inject
    private ListedSectionPersistence helper;
    /** Constructor. */
    public ListedSectionRepositoryImpl() {
        super();
    }
    /**
     * {@inheritDoc} Get {@link #helper}.
     * @return {@inheritDoc}
     */
    @Override
    public PersistenceSupport<ListedSection> getPersistenceSupport() {
        return this.helper;
    }
}
