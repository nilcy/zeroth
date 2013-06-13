// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.infra.persistence.actor;
import javax.enterprise.inject.Default;
import zeroth.actor.entity.actor.Customer;
/**
 * Customer persistence implementation.
 * @author nilcy
 */
@Default
public class CustomerPersistenceImpl extends AbstractCompanyPersistence<Customer> implements
    CustomerPersistence {
    /** S/N. */
    private static final long serialVersionUID = 2720549212163035028L;
    /** Constructor. */
    public CustomerPersistenceImpl() {
        super();
    }
}
