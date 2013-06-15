// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.domain;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import zeroth.actor.domain.PersistenceServiceAnnotation.LevelPersistenceService;
import zeroth.framework.enterprise.domain.AbstractQueryRepositoryImpl;
import zeroth.framework.enterprise.infra.persistence.QueryPersistenceService;
import zeroth.framework.enterprise.shared.Tracer;
import zeroth.framework.standard.shared.SimpleFilter;
/**
 * Level repository implementation.
 * @author nilcy
 */
@Default
@Tracer
public class LevelRepositoryImpl extends AbstractQueryRepositoryImpl<Level, Long, SimpleFilter>
    implements LevelRepository {
    /** 製品番号 */
    private static final long serialVersionUID = 8040284229107206109L;
    /** 先進データ永続化サービス */
    @Inject
    @LevelPersistenceService
    private QueryPersistenceService<Level, Long> service;
    /** {@inheritDoc} */
    @Override
    protected QueryPersistenceService<Level, Long> getPersistenceService() {
        return service;
    }
}
