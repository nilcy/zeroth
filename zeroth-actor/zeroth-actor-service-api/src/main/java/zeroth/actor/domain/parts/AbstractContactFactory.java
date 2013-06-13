// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.domain.parts;
import zeroth.framework.standard.shared.AbstractFactory;
/**
 * Contact factory.
 * @param <T> contact type
 * @author nilcy
 */
public abstract class AbstractContactFactory<T extends Contact<T>> extends AbstractFactory<T> {
    /** コンストラクタ */
    public AbstractContactFactory() {
        super();
    }
    /**
     * Create instance.
     * @param aName contact name
     * @see AbstractFactory#create()
     * @return created instance
     */
    public T create(final String aName) {
        final T i = super.create();
        i.setName(aName);
        return i;
    }
}
