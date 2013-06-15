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
import zeroth.actor.entity.actor.Title;
import zeroth.actor.infra.persistence.PersistenceSupport;
import zeroth.actor.infra.persistence.actor.TitlePersistence;
/**
 * Title repository implementation.
 * @author nilcy
 */
@Default
@TraceLog
public class TitleRepositoryImpl extends AbstractCrudRepository<Title> implements TitleRepository {
    /** 製品番号 */
    private static final long serialVersionUID = -1122126676114741118L;
    /** title persistence I/F. */
    @Inject
    private TitlePersistence helper;
    /** コンストラクタ */
    public TitleRepositoryImpl() {
        super();
    }
    /**
     * {@inheritDoc} Get {@link #helper}.
     * @return {@inheritDoc}
     */
    @Override
    public PersistenceSupport<Title> getPersistenceSupport() {
        return this.helper;
    }
}
