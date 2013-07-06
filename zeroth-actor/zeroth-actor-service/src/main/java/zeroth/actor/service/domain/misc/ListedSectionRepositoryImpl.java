// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.domain.misc;
import java.math.BigDecimal;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import zeroth.actor.service.domain.misc.PersistenceServiceAnnotation.ListedSectionPersistenceService;
import zeroth.framework.enterprise.domain.AbstractQueryRepositoryImpl;
import zeroth.framework.enterprise.infra.persistence.QueryPersistenceService;
import zeroth.framework.enterprise.shared.Tracer;
import zeroth.framework.standard.shared.SimpleFilter;
/**
 * Listed section repository implementation.
 * @author nilcy
 */
@Default
@Tracer
public class ListedSectionRepositoryImpl extends
    AbstractQueryRepositoryImpl<ListedSection, BigDecimal, SimpleFilter> implements
    ListedSectionRepository {
    /** 製品番号 */
    private static final long serialVersionUID = 2537651945740718957L;
    /** 先進データ永続化サービス */
    @Inject
    @ListedSectionPersistenceService
    private QueryPersistenceService<ListedSection, BigDecimal> service;
    /** {@inheritDoc} */
    @Override
    protected QueryPersistenceService<ListedSection, BigDecimal> getPersistenceService() {
        return service;
    }
}
