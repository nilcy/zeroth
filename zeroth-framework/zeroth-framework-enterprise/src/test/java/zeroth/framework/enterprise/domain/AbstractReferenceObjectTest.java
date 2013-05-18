// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 * {@link AbstractReferenceObject} のユニットテスト
 * @author nilcy
 */
@SuppressWarnings("all")
public class AbstractReferenceObjectTest {
    @Test
    public final void testAbstractReferenceObject() {
        assertThat(new AbstractReferenceObject() {
        }, is(not(nullValue())));
    }
    @Test
    public final void testGetSetId() {
        final AbstractReferenceObject testee = new AbstractReferenceObject() {
        };
        assertThat(testee.getId(), is(nullValue()));
        testee.setId(Long.MAX_VALUE);
        assertThat(testee.getId(), is(Long.MAX_VALUE));
    }
}
