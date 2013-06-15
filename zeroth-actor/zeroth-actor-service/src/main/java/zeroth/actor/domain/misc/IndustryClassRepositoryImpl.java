// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.domain.misc;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import zeroth.actor.domain.misc.PersistenceServiceAnnotation.IndustryClassPersistenceService;
import zeroth.framework.enterprise.domain.AbstractQueryRepositoryImpl;
import zeroth.framework.enterprise.infra.persistence.QueryPersistenceService;
import zeroth.framework.enterprise.shared.Tracer;
import zeroth.framework.standard.shared.SimpleFilter;
/**
 * 業種リポジトリ
 * @author nilcy
 */
@Default
@Tracer
public class IndustryClassRepositoryImpl extends
    AbstractQueryRepositoryImpl<IndustryClass, Long, SimpleFilter> implements
    IndustryClassRepository {
    /** 製品番号 */
    private static final long serialVersionUID = 2537651945740718957L;
    /** 先進データ永続化サービス */
    @Inject
    @IndustryClassPersistenceService
    private QueryPersistenceService<IndustryClass, Long> service;
    /** {@inheritDoc} */
    @Override
    protected QueryPersistenceService<IndustryClass, Long> getPersistenceService() {
        return service;
    }
}
