// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.domain;
import zeroth.actor.service.domain.parts.Auth;
import zeroth.framework.standard.shared.AbstractFactory;
/**
 * Member authority factory.
 * @author nilcy
 */
public class MemberAuthFactory extends AbstractFactory<MemberAuth> {
    /** コンストラクタ */
    public MemberAuthFactory() {
        super();
    }
    /**
     * Create instance.
     * @see AbstractFactory#create()
     * @param aMember member
     * @param aAccount account
     * @param aAuth authority
     * @return created instance
     */
    public MemberAuth create(final Member aMember, final String aAccount, final Auth aAuth) {
        final MemberAuth i = super.create();
        i.setMember(aMember);
        i.setAccount(aAccount);
        i.setAuth(aAuth);
        return i;
    }
}
