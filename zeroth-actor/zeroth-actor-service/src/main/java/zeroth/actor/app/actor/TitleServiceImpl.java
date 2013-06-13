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
import zeroth.actor.domain.Repository;
import zeroth.actor.domain.actor.TitleRepository;
import zeroth.actor.entity.actor.Title;
/**
 * Title service implementation.
 * @author nilcy
 */
@Stateless
@Default
@TraceLog
public class TitleServiceImpl extends AbstractCrudService<Title> implements TitleServiceLocal {
    /** S/N. */
    private static final long serialVersionUID = -2055548765950043371L;
    /** title repository I/F. */
    @Inject
    private TitleRepository repository;
    /** Constructor. */
    public TitleServiceImpl() {
        super();
    }
    /**
     * {@inheritDoc} Get {@link #repository}.
     */
    @Override
    protected Repository<Title> getRepository() {
        return this.repository;
    }
}
