// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.domain;
import zeroth.actor.service.domain.parts.CustomerContactFactory;
/**
 * Customer factory.
 * @author nilcy
 */
public class CustomerFactory extends AbstractCompanyFactory<Customer> {
    /** コンストラクタ */
    public CustomerFactory() {
        super();
    }
    /**
     * {@inheritDoc}
     * <ul>
     * <li>create customer contact instance.</li>
     * </ul>
     * @return {@inheritDoc}
     */
    @Override
    public Customer create() {
        final Customer i = super.create();
        i.setContact(new CustomerContactFactory().create());
        return i;
    }
}
