// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.domain;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import zeroth.actor.service.domain.Partner;
import zeroth.actor.service.domain.PersistenceServiceAnnotation.PartnerPersistenceService;
import zeroth.framework.enterprise.domain.AbstractQueryRepositoryImpl;
import zeroth.framework.enterprise.infra.persistence.QueryPersistenceService;
import zeroth.framework.enterprise.shared.Tracer;
import zeroth.framework.standard.shared.SimpleFilter;
/**
 * Partner repository implementation.
 * @author nilcy
 */
@Default
@Tracer
public class PartnerRepositoryImpl extends AbstractQueryRepositoryImpl<Partner, Long, SimpleFilter>
    implements PartnerRepository {
    /** 製品番号 */
    private static final long serialVersionUID = 3003296026718089910L;
    /** 先進データ永続化サービス */
    @Inject
    @PartnerPersistenceService
    private QueryPersistenceService<Partner, Long> service;
    /** {@inheritDoc} */
    @Override
    protected QueryPersistenceService<Partner, Long> getPersistenceService() {
        return service;
    }
}
