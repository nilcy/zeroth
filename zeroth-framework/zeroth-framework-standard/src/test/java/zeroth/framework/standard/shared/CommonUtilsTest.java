// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.shared;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static zeroth.framework.standard.shared.CommonUtils.*;
import java.lang.reflect.InvocationTargetException;
import org.junit.Ignore;
import org.junit.Test;
/**
 * {@link CommonUtils} のユニットテスト
 * @author nilcy
 */
@SuppressWarnings("all")
public final class CommonUtilsTest {
    @Test
    public void testNotNull() {
        assertThat(notNull("check"), is("check"));
        try {
            CommonUtils.notNull(null);
            fail();
        } catch (final NullPointerException e) {
        }
    }
    @Test
    public void testNullSafe() {
        assertThat(nullSafe("check", "safe"), is("check"));
        assertThat(nullSafe(null, "safe"), is("safe"));
        assertThat(nullSafe(null, null), is(nullValue()));
    }
    @Test
    public void testCopyProperties() throws IllegalAccessException, InvocationTargetException {
        final Fuga fuga = new Fuga("foo#1", "bar#1");
        final Hoge hoge = new Hoge();
        copyProperties(fuga, hoge);
        assertThat(hoge.getFoo(), is("foo#1"));
        assertThat(hoge.getBar(), is("bar#1"));
        assertThat(hoge.getBaz(), is(nullValue()));
    }
    @Test
    public void testCopyProperty() {
        final Fuga fuga = new Fuga();
        copyProperty(fuga, "foo", "foo#1");
        assertThat(fuga.getFoo(), is("foo#1"));
    }
    @Test
    public void testShallowCopy() {
        final Fuga fuga = new Fuga("foo#1", "bar#1");
        final Fuga fuga2 = shallowCopy(fuga);
        assertThat(fuga2.getFoo(), is(fuga.getFoo()));
        assertThat(fuga2.getBar(), is(fuga.getBar()));
    }
    @Test
    @Ignore("java.io.NotSerializableException")
    public void testDeepCopy() {
        final Fuga fuga = new Fuga("foo#1", "bar#1");
        final Fuga fuga2 = deepCopy(fuga);
        assertThat(fuga2.getFoo(), is(fuga.getFoo()));
        assertThat(fuga2.getBar(), is(fuga.getBar()));
    }
    public class Fuga extends AbstractDataObject {
        private String foo;
        private String bar;
        public Fuga() {
            super();
        }
        public Fuga(final String aFoo, final String aBar) {
            foo = aFoo;
            bar = aBar;
        }
        public String getFoo() {
            return foo;
        }
        public void setFoo(final String aFoo) {
            foo = aFoo;
        }
        public String getBar() {
            return bar;
        }
        public void setBar(final String aBar) {
            bar = aBar;
        }
    }
    public class Hoge extends AbstractDataObject {
        private String foo;
        private String bar;
        private String baz;
        public Hoge() {
        }
        public String getFoo() {
            return foo;
        }
        public void setFoo(final String aFoo) {
            foo = aFoo;
        }
        public String getBar() {
            return bar;
        }
        public void setBar(final String aBar) {
            bar = aBar;
        }
        public String getBaz() {
            return baz;
        }
        public void setBaz(final String aBaz) {
            baz = aBaz;
        }
    }
}
