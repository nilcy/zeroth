// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
/**
 * {@link AbstractAuditable} のユニットテスト
 * @author nilcy
 */
@SuppressWarnings("all")
public final class AbstractAuditableTest {
    private TestAuditable testee;
    private static final Date TODAY = new Date();
    @Before
    public void before() {
        this.testee = new TestAuditable();
    }
    @Test
    public void testAbstractRevisedObject() {
        assertThat(new AbstractAuditable() {
        }, is(not(nullValue())));
    }
    @Test
    public void testGetSetCreatedBy() {
        assertThat(this.testee.getCreatedBy(), is(nullValue()));
        this.testee.setCreatedBy(1L);
        assertThat(this.testee.getCreatedBy(), is(1L));
    }
    @Test
    public void testGetSetCreatedDate() {
        assertThat(this.testee.getCreatedDate(), is(nullValue()));
        this.testee.setCreatedDate(TODAY);
        assertThat(this.testee.getCreatedDate(), is(TODAY));
    }
    @Test
    public void testGetSetLastModifiedBy() {
        assertThat(this.testee.getLastModifiedBy(), is(nullValue()));
        this.testee.setLastModifiedBy(1L);
        assertThat(this.testee.getLastModifiedBy(), is(1L));
    }
    @Test
    public void testGetSetUpdated() {
        assertThat(this.testee.getLastModifiedDate(), is(nullValue()));
        this.testee.setLastModifiedDate(TODAY);
        assertThat(this.testee.getLastModifiedDate(), is(TODAY));
    }
    @Test
    public void testSameIdentityAs() {
        assertThat(this.testee.sameIdentityAs(null), is(false));
        final TestAuditable other = new TestAuditable();
        assertThat(this.testee.sameIdentityAs(other), is(true));
        this.testee.setId(0L);
        other.setId(0L);
        assertThat(this.testee.sameIdentityAs(other), is(true));
        this.testee.setId(0L);
        other.setId(1L);
        assertThat(this.testee.sameIdentityAs(other), is(false));
    }
}
