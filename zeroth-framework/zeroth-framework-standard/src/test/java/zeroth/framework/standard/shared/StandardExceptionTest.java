// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.shared;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 * {@link StandardException} のユニットテスト
 * @author nilcy
 */
@SuppressWarnings("all")
public class StandardExceptionTest {
    @Test
    public final void testStandardException() {
        assertThat(new StandardException(), is(not(nullValue())));
    }
    @Test
    public final void testStandardExceptionString() {
        assertThat(new StandardException("message"), is(not(nullValue())));
    }
    @Test
    public final void testStandardExceptionThrowable() {
        assertThat(new StandardException(new Throwable()), is(not(nullValue())));
    }
    @Test
    public final void testStandardExceptionStringThrowable() {
        assertThat(new StandardException("message", new Throwable()), is(not(nullValue())));
    }
    @Test
    public final void testStandardExceptionStringThrowableBooleanBoolean() {
        assertThat(new StandardException("message", new Throwable(), true, true),
            is(not(nullValue())));
    }
}
