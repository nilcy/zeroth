// ========================================================================
// Copyright (C) Kuzumeji Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.shared.commons.lang;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import java.text.Annotation;
import org.apache.commons.lang3.AnnotationUtils;
import org.junit.Test;
/**
 * {@link AnnotationUtils}
 * @author nilcy
 */
@SuppressWarnings("all")
public class AnnotationUtilsTest {
    @Test
    public void test() {
        assertThat(AnnotationUtils.isValidAnnotationMemberType(null), is(false));
        assertThat(AnnotationUtils.isValidAnnotationMemberType(String.class), is(true));
        assertThat(AnnotationUtils.isValidAnnotationMemberType(Class.class), is(true));
        assertThat(AnnotationUtils.isValidAnnotationMemberType(Boolean.class), is(false));
        assertThat(AnnotationUtils.isValidAnnotationMemberType(Character.class), is(false));
        assertThat(AnnotationUtils.isValidAnnotationMemberType(Byte.class), is(false));
        assertThat(AnnotationUtils.isValidAnnotationMemberType(Short.class), is(false));
        assertThat(AnnotationUtils.isValidAnnotationMemberType(Integer.class), is(false));
        assertThat(AnnotationUtils.isValidAnnotationMemberType(Long.class), is(false));
        assertThat(AnnotationUtils.isValidAnnotationMemberType(Float.class), is(false));
        assertThat(AnnotationUtils.isValidAnnotationMemberType(Double.class), is(false));
        assertThat(AnnotationUtils.isValidAnnotationMemberType(Void.class), is(false));
        assertThat(AnnotationUtils.isValidAnnotationMemberType(Annotation.class), is(false));
        assertThat(AnnotationUtils.isValidAnnotationMemberType(Enum.class), is(false));
    }
}
