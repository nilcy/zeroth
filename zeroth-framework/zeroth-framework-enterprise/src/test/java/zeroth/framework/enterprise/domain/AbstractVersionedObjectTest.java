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
 * {@link AbstractVersionedObject} のユニットテスト
 * @author nilcy
 */
@SuppressWarnings("all")
public class AbstractVersionedObjectTest {
    @Test
    public final void testAbstractVersioningObject() {
        assertThat(new AbstractVersionedObject() {
        }, is(not(nullValue())));
    }
    @Test
    public final void testGetSetId() {
        final AbstractVersionedObject testee = new AbstractVersionedObject() {
        };
        assertThat(testee.getVersion(), is(nullValue()));
        testee.setVersion(Long.MAX_VALUE);
        assertThat(testee.getVersion(), is(Long.MAX_VALUE));
    }
}
