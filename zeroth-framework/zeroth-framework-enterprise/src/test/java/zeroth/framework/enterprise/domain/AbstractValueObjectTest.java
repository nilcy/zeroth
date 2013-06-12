// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import zeroth.framework.standard.shared.AbstractValueObject;
/**
 * {@link AbstractValueObject} のユニットテスト
 * @author nilcy
 */
@SuppressWarnings("all")
public class AbstractValueObjectTest {
    private TestValue testee;
    @Before
    public void before() {
        testee = new TestValue();
    }
    @Test
    public final void testAbstractValueObject() {
        assertThat(testee, is(not(nullValue())));
    }
    @Test
    public void testSameValueAs() {
        assertThat(testee.sameValueAs(null), is(false));
        final TestValue other = new TestValue();
        assertThat(testee.sameValueAs(other), is(true));
        testee.setFoo("foo-00");
        other.setFoo("foo-00");
        assertThat(testee.sameValueAs(other), is(true));
        testee.setFoo("foo-00");
        other.setFoo("foo-01");
        assertThat(testee.sameValueAs(other), is(false));
    }
}
