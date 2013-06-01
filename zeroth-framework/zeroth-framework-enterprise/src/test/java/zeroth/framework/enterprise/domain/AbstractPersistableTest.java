// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.googlecode.jeeunit.JeeunitRunner;
import com.googlecode.jeeunit.Transactional;
/**
 * {@link AbstractPersistable} のユニットテスト
 * @author nilcy
 */
@RunWith(JeeunitRunner.class)
@Transactional
@SuppressWarnings("all")
public final class AbstractPersistableTest {
    private TestPersistable testee;
    @Produces
    @PersistenceContext(unitName = "primary")
    private EntityManager entityManager;
    @Before
    public void before() {
        this.testee = new TestPersistable();
    }
    @Test
    public void testAbstractReferenceObject() {
        assertThat(this.testee, is(not(nullValue())));
    }
    @Test
    public void testGetSetId() {
        assertThat(this.testee.getId(), is(nullValue()));
        this.testee.setId(Long.valueOf(0L));
        assertThat(this.testee.getId(), is(Long.valueOf(0L)));
    }
    @Test
    public void testSameIdentityAs() {
        final TestPersistable nullObject = null;
        assertThat(this.testee.sameIdentityAs(nullObject), is(false));
        final TestPersistable other = new TestPersistable();
        assertThat(this.testee.sameIdentityAs(other), is(true));
        this.testee.setId(0L);
        other.setId(0L);
        assertThat(this.testee.sameIdentityAs(other), is(true));
        this.testee.setId(0L);
        other.setId(1L);
        assertThat(this.testee.sameIdentityAs(other), is(false));
    }
    @Test
    public void testIdentity() {
        assertThat(this.testee.identity(), is(nullValue()));
        this.testee.setId(0L);
        assertThat(this.testee.identity(), is(0L));
    }
    @Test
    public void testCallback() {
        assertThat(this.testee.isPersisted(), is(false));
        this.entityManager.persist(this.testee);
        this.entityManager.flush();
        assertThat(this.testee.isPersisted(), is(true));
        for (final TestPersistable o : this.entityManager.createQuery(
            "select e from TestPersistable e", TestPersistable.class).getResultList()) {
            assertThat(o.isPersisted(), is(true));
        }
    }
}
