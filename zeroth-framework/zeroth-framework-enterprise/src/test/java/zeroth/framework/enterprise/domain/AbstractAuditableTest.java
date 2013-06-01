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
    private EntityManager entityManager;
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
    @Test
    public void testCallback() {
        assertThat(this.testee.getCreatedDate(), is(nullValue()));
        assertThat(this.testee.getLastModifiedDate(), is(nullValue()));
        this.entityManager.persist(this.testee);
        this.entityManager.flush();
        assertThat(this.testee.getCreatedDate(), is(not(nullValue())));
        assertThat(this.testee.getLastModifiedDate(), is(not(nullValue())));
        assertThat(this.testee.getCreatedDate(), is(this.testee.getLastModifiedDate()));
        for (final TestAuditable o : this.entityManager.createQuery(
            "select e from TestAuditable e", TestAuditable.class).getResultList()) {
            o.setLastModifiedBy(0L);
            this.entityManager.merge(o);
            this.entityManager.flush();
            assertThat(o.getCreatedDate(), is(not(o.getLastModifiedDate())));
        }
    }
}
