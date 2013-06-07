// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import java.util.Date;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.googlecode.jeeunit.JeeunitRunner;
import com.googlecode.jeeunit.Transactional;
/**
 * {@link AbstractAuditable} のユニットテスト
 * @author nilcy
 */
@RunWith(JeeunitRunner.class)
@Transactional
@SuppressWarnings("all")
public final class AbstractAuditableTest {
    private TestAuditable testee;
    @Produces
    @PersistenceContext(unitName = "primary")
    private EntityManager manager;
    private static final Date TODAY = new Date();
    @Before
    public void before() {
        testee = new TestAuditable();
    }
    @Test
    public void testAbstractRevisedObject() {
        assertThat(new AbstractAuditable() {
        }, is(not(nullValue())));
    }
    @Test
    public void testGetSetCreatedBy() {
        assertThat(testee.getCreatedBy(), is(nullValue()));
        testee.setCreatedBy(1L);
        assertThat(testee.getCreatedBy(), is(1L));
    }
    @Test
    public void testGetSetCreatedDate() {
        assertThat(testee.getCreatedDate(), is(nullValue()));
        testee.setCreatedDate(TODAY);
        assertThat(testee.getCreatedDate(), is(TODAY));
    }
    @Test
    public void testGetSetLastModifiedBy() {
        assertThat(testee.getLastModifiedBy(), is(nullValue()));
        testee.setLastModifiedBy(1L);
        assertThat(testee.getLastModifiedBy(), is(1L));
    }
    @Test
    public void testGetSetUpdated() {
        assertThat(testee.getLastModifiedDate(), is(nullValue()));
        testee.setLastModifiedDate(TODAY);
        assertThat(testee.getLastModifiedDate(), is(TODAY));
    }
    @Test
    public void testSameIdentityAs() {
        assertThat(testee.sameIdentityAs(null), is(false));
        final TestAuditable other = new TestAuditable();
        assertThat(testee.sameIdentityAs(other), is(true));
        testee.setId(0L);
        other.setId(0L);
        assertThat(testee.sameIdentityAs(other), is(true));
        testee.setId(0L);
        other.setId(1L);
        assertThat(testee.sameIdentityAs(other), is(false));
    }
    @Test
    public void testCallback() {
        assertThat(testee.getCreatedDate(), is(nullValue()));
        assertThat(testee.getLastModifiedDate(), is(nullValue()));
        manager.persist(testee);
        manager.flush();
        assertThat(testee.getCreatedDate(), is(not(nullValue())));
        assertThat(testee.getLastModifiedDate(), is(not(nullValue())));
        assertThat(testee.getCreatedDate(), is(testee.getLastModifiedDate()));
        for (final TestAuditable o : manager.createQuery("select e from TestAuditable e",
            TestAuditable.class).getResultList()) {
            o.setLastModifiedBy(0L);
            manager.merge(o);
            manager.flush();
            assertThat(o.getCreatedDate(), is(not(o.getLastModifiedDate())));
        }
    }
}
