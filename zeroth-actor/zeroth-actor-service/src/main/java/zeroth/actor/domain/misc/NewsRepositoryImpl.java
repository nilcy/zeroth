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
import zeroth.actor.entity.misc.News;
import zeroth.actor.infra.persistence.PersistenceSupport;
import zeroth.actor.infra.persistence.misc.NewsPersistence;
/**
 * News repository implementation.
 * @author nilcy
 */
@Default
@TraceLog
public class NewsRepositoryImpl extends AbstractCrudRepository<News> implements NewsRepository {
    /** S/N. */
    private static final long serialVersionUID = 8151517797978098457L;
    /** news persistence I/F. */
    @Inject
    private NewsPersistence helper;
    /** Constructor. */
    public NewsRepositoryImpl() {
        super();
    }
    /**
     * {@inheritDoc} Get {@link #helper}.
     * @return {@inheritDoc}
     */
    @Override
    public PersistenceSupport<News> getPersistenceSupport() {
        return this.helper;
    }
}
