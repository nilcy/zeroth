// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.domain;
import java.math.BigDecimal;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import zeroth.actor.service.domain.PersistenceServiceAnnotation.LevelPersistenceService;
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
public class LevelRepositoryImpl extends
    AbstractQueryRepositoryImpl<Level, BigDecimal, SimpleFilter> implements LevelRepository {
    /** 製品番号 */
    private static final long serialVersionUID = 8040284229107206109L;
    /** 先進データ永続化サービス */
    @Inject
    @LevelPersistenceService
    private QueryPersistenceService<Level, BigDecimal> service;
    /** {@inheritDoc} */
    @Override
    protected QueryPersistenceService<Level, BigDecimal> getPersistenceService() {
        return service;
    }
}
