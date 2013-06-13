// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.domain.actor;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import zeroth.actor.common.TraceLog;
import zeroth.actor.domain.AbstractCrudRepository;
import zeroth.actor.entity.actor.Customer;
import zeroth.actor.infra.persistence.PersistenceSupport;
import zeroth.actor.infra.persistence.actor.CustomerPersistence;
/**
 * Customer repository implementation.
 * @author nilcy
 */
@Default
@TraceLog
public class CustomerRepositoryImpl extends AbstractCrudRepository<Customer> implements
    CustomerRepository {
    /** S/N. */
    private static final long serialVersionUID = 3003296026718089910L;
    /** customer persistence I/F. */
    @Inject
    private CustomerPersistence helper;
    /** Constructor. */
    public CustomerRepositoryImpl() {
        super();
    }
    /**
     * {@inheritDoc} Get {@link #helper}.
     * @return {@inheritDoc}
     */
    @Override
    public PersistenceSupport<Customer> getPersistenceSupport() {
        return this.helper;
    }
}
