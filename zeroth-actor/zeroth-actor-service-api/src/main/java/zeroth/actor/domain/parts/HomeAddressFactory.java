// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.domain.parts;
import zeroth.framework.standard.shared.AbstractFactory;
/**
 * Home address factory.
 * @author nilcy
 */
public class HomeAddressFactory extends AbstractFactory<HomeAddress> {
    /** Constructor. */
    public HomeAddressFactory() {
        super();
    }
    /**
     * Create instance.
     * @see AbstractFactory#create()
     * @param aCode zip code
     * @return created instance
     */
    public HomeAddress create(final String aCode) {
        final HomeAddress i = super.create();
        i.setCode(aCode);
        return i;
    }
    /**
     * Create instance.
     * @see AbstractFactory#create()
     * @param aCode zip code
     * @param aName address name
     * @return created instance
     */
    public HomeAddress create(final String aCode, final String aName) {
        final HomeAddress i = super.create();
        i.setCode(aCode);
        i.setName(aName);
        return i;
    }
    /**
     * Create instance.
     * @param aCode zip code
     * @param aPref prefecture
     * @param aCity city
     * @param aTown town
     * @return created instance
     */
    public HomeAddress create(final String aCode, final String aPref, final String aCity,
        final String aTown) {
        final HomeAddress i = create(aCode);
        i.setPref(aPref);
        i.setCity(aCity);
        i.setTown(aTown);
        return i;
    }
}
