// ========================================================================
// Copyright (C) Kuzumeji Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.shared.commons.codec;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
/**
 * {@link StringUtils}
 * @author nilcy
 */
@SuppressWarnings("all")
public class StringUtilsTest {
    @Test
    public void test() {
        String testee = org.apache.commons.lang3.StringUtils.EMPTY;
        assertThat(StringUtils.getBytesUnchecked(testee, "UTF-8"), is(ArrayUtils.EMPTY_BYTE_ARRAY));
        assertThat(StringUtils.getBytesIso8859_1(testee), is(ArrayUtils.EMPTY_BYTE_ARRAY));
        assertThat(StringUtils.getBytesUsAscii(testee), is(ArrayUtils.EMPTY_BYTE_ARRAY));
        assertThat(StringUtils.getBytesUtf8(testee), is(ArrayUtils.EMPTY_BYTE_ARRAY));
        assertThat(StringUtils.getBytesUtf16(testee), is(ArrayUtils.EMPTY_BYTE_ARRAY));
        assertThat(StringUtils.getBytesUtf16Le(testee), is(ArrayUtils.EMPTY_BYTE_ARRAY));
        assertThat(StringUtils.getBytesUtf16Be(testee), is(ArrayUtils.EMPTY_BYTE_ARRAY));
        assertThat(StringUtils.newString(ArrayUtils.EMPTY_BYTE_ARRAY, "UTF-8"), is(testee));
        assertThat(StringUtils.newStringIso8859_1(ArrayUtils.EMPTY_BYTE_ARRAY), is(testee));
        assertThat(StringUtils.newStringUsAscii(ArrayUtils.EMPTY_BYTE_ARRAY), is(testee));
        assertThat(StringUtils.newStringUtf8(ArrayUtils.EMPTY_BYTE_ARRAY), is(testee));
        assertThat(StringUtils.newStringUtf16(ArrayUtils.EMPTY_BYTE_ARRAY), is(testee));
        assertThat(StringUtils.newStringUtf16Le(ArrayUtils.EMPTY_BYTE_ARRAY), is(testee));
        assertThat(StringUtils.newStringUtf16Be(ArrayUtils.EMPTY_BYTE_ARRAY), is(testee));
    }
}
