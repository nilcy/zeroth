// ========================================================================
// Copyright (C) Kuzumeji Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.shared.commons.lang;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.apache.commons.lang3.CharSetUtils;
import org.junit.Test;
/**
 * {@link CharSetUtils}
 * @author nilcy
 */
@SuppressWarnings("all")
public class CharSetUtilsTest {
    @Test
    public void test() {
        assertThat(CharSetUtils.count(null, "a-z"), is(0));
        assertThat(CharSetUtils.count("", "a-z"), is(0));
        assertThat(CharSetUtils.count("hello", "k-p"), is(3));
        assertThat(CharSetUtils.count("hello", "a-e"), is(1));
        assertThat(CharSetUtils.count("hello", "a", "b", "c", "d", "e"), is(1));
        assertThat(CharSetUtils.delete(null, "a-z"), is(nullValue()));
        assertThat(CharSetUtils.delete("", "a-z"), is(""));
        assertThat(CharSetUtils.delete("hello", "hl"), is("eo"));
        assertThat(CharSetUtils.keep(null, "a-z"), is(nullValue()));
        assertThat(CharSetUtils.keep("", "a-z"), is(""));
        assertThat(CharSetUtils.keep("hello", "hl"), is("hll"));
        assertThat(CharSetUtils.squeeze(null, "a-z"), is(nullValue()));
        assertThat(CharSetUtils.squeeze("", "a-z"), is(""));
        assertThat(CharSetUtils.squeeze("hello", "k-p"), is("helo"));
    }
}
