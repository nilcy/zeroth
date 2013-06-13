// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.domain;
import zeroth.actor.domain.parts.PartnerContactFactory;
/**
 * Partner factory.
 * @author nilcy
 */
public class PartnerFactory extends AbstractStaffFactory<Partner> {
    /** コンストラクタ */
    public PartnerFactory() {
        super();
    }
    /**
     * {@inheritDoc}
     * <ul>
     * <li>create partner contact instance.</li>
     * </ul>
     * @return {@inheritDoc}
     */
    @Override
    public Partner create() {
        final Partner i = super.create();
        i.setContact(new PartnerContactFactory().create());
        return i;
    }
}
