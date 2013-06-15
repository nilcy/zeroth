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
import zeroth.actor.domain.LevelRepository;
import zeroth.actor.domain.Repository;
import zeroth.actor.entity.actor.Level;
/**
 * Level service implementation.
 * @author nilcy
 */
@Stateless
@Default
@TraceLog
public class LevelServiceImpl extends AbstractCrudService<Level> implements LevelServiceLocal {
    /** 製品番号 */
    private static final long serialVersionUID = -3833130543168027472L;
    /** level repository I/F. */
    @Inject
    private LevelRepository repository;
    /** コンストラクタ */
    public LevelServiceImpl() {
        super();
    }
    /**
     * {@inheritDoc} Get {@link #repository}.
     */
    @Override
    protected Repository<Level> getRepository() {
        return this.repository;
    }
}
