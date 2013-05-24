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
/**
 * {@link AbstractValueObject} のユニットテスト
 * @author nilcy
 */
@SuppressWarnings("all")
public class AbstractValueObjectTest {
    private TestValue testee;
    @Before
    public void before() {
        this.testee = new TestValue();
    }
    @Test
    public final void testAbstractValueObject() {
        assertThat(this.testee, is(not(nullValue())));
    }
    @Test
    public void testSameValueAs() {
        assertThat(this.testee.sameValueAs(null), is(false));
        final TestValue other = new TestValue();
        assertThat(this.testee.sameValueAs(other), is(true));
        this.testee.setFoo("foo-00");
        other.setFoo("foo-00");
        assertThat(this.testee.sameValueAs(other), is(true));
        this.testee.setFoo("foo-00");
        other.setFoo("foo-01");
        assertThat(this.testee.sameValueAs(other), is(false));
    }
}
