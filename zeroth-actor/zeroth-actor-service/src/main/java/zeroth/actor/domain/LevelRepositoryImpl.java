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
import zeroth.actor.entity.actor.Level;
import zeroth.actor.infra.persistence.PersistenceSupport;
import zeroth.actor.infra.persistence.actor.LevelPersistence;
/**
 * Level repository implementation.
 * @author nilcy
 */
@Default
@TraceLog
public class LevelRepositoryImpl extends AbstractCrudRepository<Level> implements LevelRepository {
    /** 製品番号 */
    private static final long serialVersionUID = 8040284229107206109L;
    /** level persistence I/F. */
    @Inject
    private LevelPersistence helper;
    /** コンストラクタ */
    public LevelRepositoryImpl() {
        super();
    }
    /**
     * {@inheritDoc} Get {@link #helper}.
     * @return {@inheritDoc}
     */
    @Override
    public PersistenceSupport<Level> getPersistenceSupport() {
        return this.helper;
    }
}
