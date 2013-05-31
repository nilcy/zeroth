// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.shared;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import zeroth.framework.standard.Example;
/**
 * {@link Example} のユニットテスト
 * @author nilcy
 */
@SuppressWarnings("all")
public class AbstractDataObjectTest {
    /** テスト用データオブジェクト */
    private final TestDataObject testee = new TestDataObject();
    @Before
    public void before() {
        this.testee.setFoo("foo-01");
        this.testee.setBar("bar-01");
    }
    @Test
    public final void testAbstractDataObject() {
        assertThat(new TestDataObject(), is(not(nullValue())));
    }
    @Test
    public final void testToString() {
        assertThat(this.testee.toString(), is("TestDataObject[foo=foo-01,bar=bar-01]"));
    }
    @Test
    public final void testEqualsObject() {
        final TestDataObject eqObject = new TestDataObject();
        eqObject.setFoo("foo-01");
        eqObject.setBar("bar-01");
        assertThat(this.testee.equals(eqObject), is(true));
        final TestDataObject neqObject = new TestDataObject();
        neqObject.setFoo("foo-02");
        neqObject.setBar("bar-02");
        assertThat(this.testee.equals(neqObject), is(false));
    }
    @Test
    public final void testHashCode() {
        assertThat(this.testee.hashCode(), is(not(nullValue())));
    }
}
