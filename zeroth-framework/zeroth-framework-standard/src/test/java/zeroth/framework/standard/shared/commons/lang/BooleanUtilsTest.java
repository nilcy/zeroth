// ========================================================================
// Copyright (C) Kuzumeji Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.shared.commons.lang;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.apache.commons.lang3.BooleanUtils;
import org.junit.Test;
/**
 * {@link BooleanUtils}
 * @author nilcy
 */
@SuppressWarnings("all")
public class BooleanUtilsTest {
    @Test
    public void test() {
        assertThat(BooleanUtils.and(new boolean[] { true }), is(true));
        assertThat(BooleanUtils.and(new boolean[] { true, false }), is(false));
        assertThat(BooleanUtils.isFalse(false), is(true));
        assertThat(BooleanUtils.isNotFalse(false), is(false));
        assertThat(BooleanUtils.isNotTrue(true), is(false));
        assertThat(BooleanUtils.isTrue(true), is(true));
        assertThat(BooleanUtils.negate(Boolean.FALSE), is(true));
        assertThat(BooleanUtils.or(new boolean[] { true }), is(true));
        assertThat(BooleanUtils.or(new boolean[] { true, false }), is(true));
        assertThat(BooleanUtils.toBoolean(Boolean.TRUE), is(true));
        assertThat(BooleanUtils.toBoolean(0), is(false));
        assertThat(BooleanUtils.toBoolean(1), is(true));
        assertThat(BooleanUtils.toBoolean((String) null), is(false));
        assertThat(BooleanUtils.toBoolean("true"), is(true));
        assertThat(BooleanUtils.toBoolean("hoge"), is(false));
        assertThat(BooleanUtils.toBooleanDefaultIfNull(null, false), is(false));
        assertThat(BooleanUtils.toBooleanObject(0), is(Boolean.FALSE));
        assertThat(BooleanUtils.toBooleanObject(1), is(Boolean.TRUE));
        assertThat(BooleanUtils.toInteger(true), is(1));
        assertThat(BooleanUtils.toInteger(false), is(0));
        assertThat(BooleanUtils.toIntegerObject(true), is(Integer.valueOf(1)));
        assertThat(BooleanUtils.toIntegerObject(false), is(Integer.valueOf(0)));
        assertThat(BooleanUtils.toString(true, "true", "false"), is("true"));
        assertThat(BooleanUtils.toString(false, "true", "false"), is("false"));
        assertThat(BooleanUtils.toStringOnOff(true), is("on"));
        assertThat(BooleanUtils.toStringOnOff(false), is("off"));
        assertThat(BooleanUtils.toStringTrueFalse(true), is("true"));
        assertThat(BooleanUtils.toStringTrueFalse(false), is("false"));
        assertThat(BooleanUtils.toStringYesNo(true), is("yes"));
        assertThat(BooleanUtils.toStringYesNo(false), is("no"));
        assertThat(BooleanUtils.xor(new boolean[] { true }), is(true));
        assertThat(BooleanUtils.xor(new boolean[] { true, false }), is(true));
        assertThat(BooleanUtils.xor(new boolean[] { true, true }), is(false));
    }
}
