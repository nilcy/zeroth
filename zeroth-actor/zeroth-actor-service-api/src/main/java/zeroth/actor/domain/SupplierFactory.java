// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.domain;
import zeroth.actor.domain.parts.SupplierContactFactory;
/**
 * Supplier factory.
 * @author nilcy
 */
public class SupplierFactory extends AbstractCompanyFactory<Supplier> {
    /** Constructor. */
    public SupplierFactory() {
        super();
    }
    /**
     * {@inheritDoc}
     * <ul>
     * <li>create supplier contact instance.</li>
     * </ul>
     * @return {@inheritDoc}
     */
    @Override
    public Supplier create() {
        final Supplier i = super.create();
        i.setContact(new SupplierContactFactory().create());
        return i;
    }
}
