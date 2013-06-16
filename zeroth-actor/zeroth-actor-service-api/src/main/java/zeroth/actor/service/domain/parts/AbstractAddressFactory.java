// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.domain.parts;
import zeroth.framework.standard.shared.AbstractFactory;
/**
 * example factory.
 * @param <T> address type
 * @author nilcy
 */
public abstract class AbstractAddressFactory<T extends Address<T>> extends AbstractFactory<T> {
    /** コンストラクタ */
    public AbstractAddressFactory() {
        super();
    }
    /**
     * Create instance.
     * @see AbstractFactory#create()
     * @param aCode zip code
     * @return created instance
     */
    public T create(final String aCode) {
        final T i = super.create();
        i.setCode(aCode);
        return i;
    }
    /**
     * Create instance.
     * @see #create(String)
     * @param aName address name
     * @param aCode zip code
     * @param aPref prefecture
     * @param aCity city
     * @param aTown town
     * @param aStreet street
     * @return created instance
     */
    public T create(final String aName, final String aCode, final String aPref, final String aCity,
        final String aTown, final String aStreet) {
        final T i = create(aCode);
        i.setName(aName);
        i.setPref(aPref);
        i.setCity(aCity);
        i.setTown(aTown);
        i.setStreet(aStreet);
        return i;
    }
}
