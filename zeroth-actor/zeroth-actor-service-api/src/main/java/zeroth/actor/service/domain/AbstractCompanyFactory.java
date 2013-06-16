// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.domain;
import zeroth.actor.service.domain.parts.OfficeAddressFactory;
import zeroth.framework.standard.shared.AbstractFactory;
/**
 * Company factory.
 * @param <T> company object type
 * @author nilcy
 */
public abstract class AbstractCompanyFactory<T extends Company<T>> extends AbstractFactory<T> {
    /** コンストラクタ */
    protected AbstractCompanyFactory() {
        super();
    }
    /**
     * {@inheritDoc}
     * <ul>
     * <li>create head office address instance.</li>
     * </ul>
     * @return {@inheritDoc}
     */
    @Override
    public T create() {
        final T i = super.create();
        i.setAddress(new OfficeAddressFactory().create());
        return i;
    }
}
