// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.app.actor;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import zeroth.actor.app.AbstractCrudService;
import zeroth.actor.common.TraceLog;
import zeroth.actor.domain.Repository;
import zeroth.actor.domain.actor.CustomerRepository;
import zeroth.actor.entity.actor.Customer;
/**
 * Customer service implementation.
 * @author nilcy
 */
@Stateless
@Default
@TraceLog
public class CustomerServiceImpl extends AbstractCrudService<Customer> implements
    CustomerServiceLocal {
    /** S/N. */
    private static final long serialVersionUID = 2537651945740718957L;
    /** customer repository I/F. */
    @Inject
    private CustomerRepository repository;
    /** Constructor. */
    public CustomerServiceImpl() {
        super();
    }
    /**
     * {@inheritDoc} Get {@link #repository}.
     */
    @Override
    protected Repository<Customer> getRepository() {
        return this.repository;
    }
}
