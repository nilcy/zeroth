// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.shared;
import java.lang.reflect.ParameterizedType;
/**
 * Entity factory.
 * @param <T> entity type
 * @author nilcy
 */
public abstract class AbstractFactory<T extends DataObject> {
    /** Constructor. */
    protected AbstractFactory() {
        super();
    }
    /**
     * Create instance.
     * @return created instance
     */
    @SuppressWarnings("unchecked")
    public T create() {
        try {
            return ((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0]).newInstance();
        } catch (final InstantiationException e) {
            throw new StandardRuntimeException(e);
        } catch (final IllegalAccessException e) {
            throw new StandardRuntimeException(e);
        }
    }
    // /**
    // * Create instance.
    // * @param aKeyword keyword
    // * @return created instance
    // */
    // public T createKeyword(final String aKeyword) {
    // final T i = create();
    // i.setKeyword(aKeyword);
    // return i;
    // }
}
