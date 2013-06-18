// ========================================================================
// Copyright (C) Kuzumeji Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.shared.commons.lang;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.apache.commons.lang3.CharUtils;
import org.junit.Test;
/**
 * {@link CharUtils}
 * @author nilcy
 */
@SuppressWarnings("all")
public class CharUtilsTest {
    @Test
    public void test() {
        assertThat(CharUtils.CR, is('\r'));
        assertThat(CharUtils.LF, is('\n'));
        assertThat(CharUtils.isAscii('a'), is(true));
        assertThat(CharUtils.isAscii('0'), is(true));
        assertThat(CharUtils.isAscii('あ'), is(false));
        assertThat(CharUtils.isAsciiAlpha('a'), is(true));
        assertThat(CharUtils.isAsciiAlpha('0'), is(false));
        assertThat(CharUtils.isAsciiAlphaLower('a'), is(true));
        assertThat(CharUtils.isAsciiAlphaLower('A'), is(false));
        assertThat(CharUtils.isAsciiAlphanumeric('a'), is(true));
        assertThat(CharUtils.isAsciiAlphanumeric('0'), is(true));
        assertThat(CharUtils.isAsciiAlphanumeric('-'), is(false));
        assertThat(CharUtils.isAsciiAlphaUpper('a'), is(false));
        assertThat(CharUtils.isAsciiAlphaUpper('A'), is(true));
        assertThat(CharUtils.isAsciiControl('a'), is(false));
        assertThat(CharUtils.isAsciiControl('\r'), is(true));
        assertThat(CharUtils.isAsciiNumeric('a'), is(false));
        assertThat(CharUtils.isAsciiNumeric('0'), is(true));
        assertThat(CharUtils.isAsciiPrintable('a'), is(true));
        assertThat(CharUtils.isAsciiPrintable('\r'), is(false));
        assertThat(CharUtils.toChar("a"), is('a'));
        assertThat(CharUtils.toChar((String) null, '-'), is('-'));
        assertThat(CharUtils.toIntValue('0'), is(0));
        assertThat(CharUtils.toString('a'), is("a"));
        assertThat(CharUtils.unicodeEscaped(' '), is("\\u0020"));
    }
}
