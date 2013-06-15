// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.domain;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import zeroth.actor.domain.PersistenceServiceAnnotation.TitlePersistenceService;
import zeroth.framework.enterprise.domain.AbstractQueryRepositoryImpl;
import zeroth.framework.enterprise.infra.persistence.QueryPersistenceService;
import zeroth.framework.enterprise.shared.Tracer;
import zeroth.framework.standard.shared.SimpleFilter;
/**
 * Title repository implementation.
 * @author nilcy
 */
@Default
@Tracer
public class TitleRepositoryImpl extends AbstractQueryRepositoryImpl<Title, Long, SimpleFilter>
    implements TitleRepository {
    /** 製品番号 */
    private static final long serialVersionUID = -1122126676114741118L;
    /** 先進データ永続化サービス */
    @Inject
    @TitlePersistenceService
    private QueryPersistenceService<Title, Long> service;
    /** {@inheritDoc} */
    @Override
    protected QueryPersistenceService<Title, Long> getPersistenceService() {
        return service;
    }
}
