// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.domain;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static zeroth.framework.standard.domain.DomainUtils.*;
import java.lang.reflect.InvocationTargetException;
import org.junit.Test;
import zeroth.framework.standard.shared.AbstractDataObject;
/**
 * {@link DomainUtils} のユニットテスト
 * @author nilcy
 */
@SuppressWarnings("all")
public class DomainUtilsTest {
    @Test
    public final void testNotNull() {
        assertThat(notNull("check"), is("check"));
        try {
            DomainUtils.notNull(null);
            fail();
        } catch (final NullPointerException e) {
        }
    }
    @Test
    public final void testNullSafe() {
        assertThat(nullSafe("check", "safe"), is("check"));
        assertThat(nullSafe(null, "safe"), is("safe"));
        assertThat(nullSafe(null, null), is(nullValue()));
    }
    @Test
    public final void testCopyProperties() throws IllegalAccessException, InvocationTargetException {
        final Fuga fuga = new Fuga("foo#1", "bar#1");
        final Hoge hoge = new Hoge();
        copyProperties(fuga, hoge);
        assertThat(hoge.getFoo(), is("foo#1"));
        assertThat(hoge.getBar(), is("bar#1"));
        assertThat(hoge.getBaz(), is(nullValue()));
    }
    @Test
    public final void testCopyProperty() {
        final Fuga fuga = new Fuga();
        copyProperty(fuga, "foo", "foo#1");
        assertThat(fuga.getFoo(), is("foo#1"));
    }
    public class Fuga extends AbstractDataObject<Fuga> {
        private String foo;
        private String bar;
        public Fuga() {
        }
        public Fuga(final String aFoo, final String aBar) {
            this.foo = aFoo;
            this.bar = aBar;
        }
        public String getFoo() {
            return this.foo;
        }
        public void setFoo(final String aFoo) {
            this.foo = aFoo;
        }
        public String getBar() {
            return this.bar;
        }
        public void setBar(final String aBar) {
            this.bar = aBar;
        }
    }
    public class Hoge extends AbstractDataObject<Hoge> {
        private String foo;
        private String bar;
        private String baz;
        public Hoge() {
        }
        public String getFoo() {
            return this.foo;
        }
        public void setFoo(final String aFoo) {
            this.foo = aFoo;
        }
        public String getBar() {
            return this.bar;
        }
        public void setBar(final String aBar) {
            this.bar = aBar;
        }
        public String getBaz() {
            return this.baz;
        }
        public void setBaz(final String aBaz) {
            this.baz = aBaz;
        }
    }
}
