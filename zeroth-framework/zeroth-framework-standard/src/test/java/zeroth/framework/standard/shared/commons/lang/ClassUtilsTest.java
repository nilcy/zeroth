// ========================================================================
// Copyright (C) Kuzumeji Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.shared.commons.lang;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang3.ClassUtils;
import org.junit.Test;
/**
 * {@link ClassUtils}
 * @author nilcy
 */
@SuppressWarnings("all")
public class ClassUtilsTest {
    @Test
    public void test() throws ClassNotFoundException, SecurityException, NoSuchMethodException {
        List<Class<?>> classes = new ArrayList<Class<?>>() {
            {
                add(Integer.class);
                add(Long.class);
            }
        };
        assertThat(ClassUtils.convertClassesToClassNames(classes).toArray(), is(new Object[] {
            "java.lang.Integer", "java.lang.Long" }));
        List<String> classNames = new ArrayList<String>() {
            {
                add("java.lang.Integer");
                add("java.lang.Long");
            }
        };
        assertThat(ClassUtils.convertClassNamesToClasses(classNames).toArray(),
            is(classes.toArray()));
        assertThat(ClassUtils.getAllInterfaces(String.class).toArray(), is(new Object[] {
            java.io.Serializable.class, java.lang.Comparable.class, java.lang.CharSequence.class }));
        assertThat(ClassUtils.getAllSuperclasses(HashMap.class).toArray(), is(new Object[] {
            java.util.AbstractMap.class, java.lang.Object.class }));
        assertThat(ClassUtils.getClass("java.lang.String").toString(), is("class java.lang.String"));
        assertThat(ClassUtils.getPackageCanonicalName(String.class), is("java.lang"));
        assertThat(ClassUtils.getPackageName(String.class), is("java.lang"));
        assertThat(ClassUtils.getPublicMethod(String.class, "length", new Class[] {}),
            is(not(nullValue())));
        assertThat(ClassUtils.getShortCanonicalName(String.class), is("String"));
        assertThat(ClassUtils.getShortClassName(String.class), is("String"));
        assertThat(ClassUtils.getSimpleName(String.class), is("String"));
        assertThat(ClassUtils.isAssignable(String.class, Object.class), is(true));
        assertThat(ClassUtils.isInnerClass(Foo.class), is(true));
        assertThat(ClassUtils.isInnerClass(String.class), is(false));
        assertThat(ClassUtils.isPrimitiveOrWrapper(Integer.class), is(true));
        assertThat(ClassUtils.isPrimitiveOrWrapper(String.class), is(false));
        assertThat(ClassUtils.isPrimitiveWrapper(Integer.class), is(true));
        assertThat(ClassUtils.isPrimitiveWrapper(String.class), is(false));
        assertThat(ClassUtils.primitivesToWrappers(new Class[] { Integer.class, Long.class }),
            is(not(nullValue())));
        assertThat(ClassUtils.primitiveToWrapper(Integer.class), is(not(nullValue())));
        assertThat(ClassUtils.toClass(1L, 2L), is(not(nullValue())));
        assertThat(ClassUtils.wrappersToPrimitives(new Class[] { Integer.class, Long.class }),
            is(not(nullValue())));
        assertThat(ClassUtils.wrapperToPrimitive(Integer.class), is(not(nullValue())));
    }
    class Foo {
    }
}
