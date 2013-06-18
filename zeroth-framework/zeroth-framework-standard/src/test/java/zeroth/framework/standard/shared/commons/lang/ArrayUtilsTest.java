// ========================================================================
// Copyright (C) Kuzumeji Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.shared.commons.lang;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
/**
 * {@link ArrayUtils}
 * @author nilcy
 */
@SuppressWarnings("all")
public class ArrayUtilsTest {
    @Test
    public void test() {
        assertThat(ArrayUtils.EMPTY_BOOLEAN_ARRAY.length, is(0));
        assertThat(ArrayUtils.EMPTY_BOOLEAN_OBJECT_ARRAY, is(new Boolean[] {}));
        boolean[] testee = ArrayUtils.add(null, true);
        assertThat(ArrayUtils.clone(testee), is(testee));
        assertThat(ArrayUtils.contains(testee, true), is(true));
        assertThat(ArrayUtils.contains(testee, false), is(false));
        assertThat(ArrayUtils.getLength(testee), is(1));
        assertThat(ArrayUtils.hashCode(testee), is(not(nullValue())));
        assertThat(ArrayUtils.indexOf(testee, true), is(not(ArrayUtils.INDEX_NOT_FOUND)));
        assertThat(ArrayUtils.indexOf(testee, false), is(ArrayUtils.INDEX_NOT_FOUND));
        assertThat(ArrayUtils.isEmpty(testee), is(false));
        assertThat(ArrayUtils.isEmpty(ArrayUtils.EMPTY_BOOLEAN_ARRAY), is(true));
        assertThat(ArrayUtils.isEquals(testee, new boolean[] { true }), is(true));
        assertThat(ArrayUtils.isNotEmpty(testee), is(true));
        assertThat(ArrayUtils.isSameLength(testee, new boolean[] { true }), is(true));
        assertThat(ArrayUtils.isSameType(testee, new boolean[] { true }), is(true));
        assertThat(ArrayUtils.lastIndexOf(testee, true), is(not(ArrayUtils.INDEX_NOT_FOUND)));
        assertThat(ArrayUtils.lastIndexOf(testee, false), is(ArrayUtils.INDEX_NOT_FOUND));
        boolean[] booleanNull = null;
        assertThat(ArrayUtils.nullToEmpty(booleanNull), is(ArrayUtils.EMPTY_BOOLEAN_ARRAY));
        assertThat(ArrayUtils.remove(testee, 0), is(ArrayUtils.EMPTY_BOOLEAN_ARRAY));
        assertThat(ArrayUtils.removeAll(testee, 0), is(ArrayUtils.EMPTY_BOOLEAN_ARRAY));
        assertThat(ArrayUtils.removeElement(testee, true), is(ArrayUtils.EMPTY_BOOLEAN_ARRAY));
        assertThat(ArrayUtils.removeElement(testee, false), is(testee));
        assertThat(ArrayUtils.removeElements(testee, true, false), is(ArrayUtils.EMPTY_BOOLEAN_ARRAY));
    }
}
