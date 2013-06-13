// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.domain;
import zeroth.actor.domain.parts.HomeAddress;
import zeroth.actor.domain.parts.HomeAddressFactory;
import zeroth.actor.domain.parts.MemberContact;
import zeroth.actor.domain.parts.MemberContactFactory;
/**
 * Member factory.
 * @author nilcy
 */
public class MemberFactory extends AbstractStaffFactory<Member> {
    /** コンストラクタ */
    public MemberFactory() {
        super();
    }
    /**
     * {@inheritDoc}
     * <ul>
     * <li>create home address instance.</li>
     * <li>create member contact instance.</li>
     * </ul>
     * @return {@inheritDoc}
     */
    @Override
    public Member create() {
        final Member i = super.create();
        i.setAddress(new HomeAddressFactory().create());
        i.setContact(new MemberContactFactory().create());
        return i;
    }
    /**
     * Create instance.
     * @see #create()
     * @param aAccount account
     * @return created instance
     */
    public Member create(final String aAccount) {
        final Member i = super.create();
        i.setAccount(aAccount);
        return i;
    }
    // /**
    // * Create instance.
    // * @see #create()
    // * @param aAccount account
    // * @param aFamilyName family name
    // * @return created instance
    // */
    // public Member create(final String aAccount, final String aFamilyName) {
    // final Member i = super.createStaff(aFamilyName);
    // i.setAccount(aAccount);
    // return i;
    // }
    /**
     * Create instance.
     * @see #create()
     * @param aFamilyName family name
     * @param aAccount account
     * @param aPassword password
     * @param aAddress home address
     * @param aContact member contact
     * @return created instance
     */
    public Member create(final String aFamilyName, final String aAccount, final String aPassword,
        final HomeAddress aAddress, final MemberContact aContact) {
        final Member i = createStaff(aFamilyName);
        i.setAccount(aAccount);
        i.setPassword(aPassword);
        i.setAddress(aAddress);
        i.setContact(aContact);
        return i;
    }
}
