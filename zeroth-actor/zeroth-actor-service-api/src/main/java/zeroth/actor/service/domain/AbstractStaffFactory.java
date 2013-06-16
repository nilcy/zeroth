// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.domain;
import zeroth.framework.standard.shared.AbstractFactory;
/**
 * Staff factory.
 * @param <T> staff type
 * @author nilcy
 */
public abstract class AbstractStaffFactory<T extends Staff<T>> extends AbstractFactory<T> {
    /** コンストラクタ */
    protected AbstractStaffFactory() {
        super();
    }
    /**
     * Create instance.
     * @see #create()
     * @param aFamilyName family name
     * @return created instance
     */
    public T createStaff(final String aFamilyName) {
        final T i = create();
        i.setFamilyName(aFamilyName);
        return i;
    }
}
