// ========================================================================
// Copyright (C) Kuzumeji Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.shared.commons.codec;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
/**
 * {@link DigestUtils}
 * @author nilcy
 */
@SuppressWarnings("all")
public class DigestUtilsTest {
    @Test
    public void test() {
        assertThat(DigestUtils.getMd2Digest(), is(not(nullValue())));
        assertThat(DigestUtils.getMd5Digest(), is(not(nullValue())));
        assertThat(DigestUtils.getSha1Digest(), is(not(nullValue())));
        assertThat(DigestUtils.getSha256Digest(), is(not(nullValue())));
        assertThat(DigestUtils.getSha384Digest(), is(not(nullValue())));
        assertThat(DigestUtils.getSha512Digest(), is(not(nullValue())));
        assertThat(DigestUtils.md2Hex(new byte[] {}), is(not(nullValue())));
    }
}
