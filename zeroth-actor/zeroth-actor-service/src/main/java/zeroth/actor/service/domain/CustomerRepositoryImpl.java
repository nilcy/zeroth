// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.domain;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import zeroth.actor.service.domain.Customer;
import zeroth.actor.service.domain.PersistenceServiceAnnotation.CustomerPersistenceService;
import zeroth.framework.enterprise.domain.AbstractQueryRepositoryImpl;
import zeroth.framework.enterprise.infra.persistence.QueryPersistenceService;
import zeroth.framework.enterprise.shared.Tracer;
import zeroth.framework.standard.shared.SimpleFilter;
/**
 * Customer repository implementation.
 * @author nilcy
 */
@Default
@Tracer
public class CustomerRepositoryImpl extends
    AbstractQueryRepositoryImpl<Customer, Long, SimpleFilter> implements CustomerRepository {
    /** 製品番号 */
    private static final long serialVersionUID = 3003296026718089910L;
    /** 先進データ永続化サービス */
    @Inject
    @CustomerPersistenceService
    private QueryPersistenceService<Customer, Long> service;
    /** {@inheritDoc} */
    @Override
    protected QueryPersistenceService<Customer, Long> getPersistenceService() {
        return service;
    }
}
