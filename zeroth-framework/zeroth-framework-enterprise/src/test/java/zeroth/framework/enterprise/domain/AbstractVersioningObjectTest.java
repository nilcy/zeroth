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
 * {@link AbstractVersioningObject} のユニットテスト
 * @author nilcy
 */
@SuppressWarnings("all")
public class AbstractVersioningObjectTest {
    @Test
    public final void testAbstractVersioningObject() {
        assertThat(new AbstractVersioningObject() {
        }, is(not(nullValue())));
    }
    @Test
    public final void testGetSetId() {
        final AbstractVersioningObject testee = new AbstractVersioningObject() {
        };
        assertThat(testee.getVersion(), is(nullValue()));
        testee.setVersion(Long.MAX_VALUE);
        assertThat(testee.getVersion(), is(Long.MAX_VALUE));
    }
}
