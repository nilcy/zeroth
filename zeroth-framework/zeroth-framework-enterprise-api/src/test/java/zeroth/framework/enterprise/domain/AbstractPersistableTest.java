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
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
/**
 * {@link AbstractPersistable} のユニットテスト
 * @author nilcy
 */
@RunWith(Arquillian.class)
@Transactional
@SuppressWarnings("all")
public final class AbstractPersistableTest {
    private TestPersistable testee;
    @Produces
    @PersistenceContext(unitName = "primary")
    private EntityManager manager;
    @Deployment
    public static JavaArchive deployment() {
        return ArquillianDeployment.defaultDeployment();
    }
    @Before
    public void before() {
        testee = new TestPersistable();
    }
    @Test
    public void testAbstractReferenceObject() {
        assertThat(testee, is(not(nullValue())));
    }
    @Test
    public void testGetSetId() {
        assertThat(testee.getId(), is(nullValue()));
        testee.setId(Long.valueOf(0L));
        assertThat(testee.getId(), is(Long.valueOf(0L)));
    }
    @Test
    public void testSameIdentityAs() {
        final TestPersistable nullObject = null;
        assertThat(testee.sameIdentityAs(nullObject), is(false));
        final TestPersistable other = new TestPersistable();
        assertThat(testee.sameIdentityAs(other), is(true));
        testee.setId(0L);
        other.setId(0L);
        assertThat(testee.sameIdentityAs(other), is(true));
        testee.setId(0L);
        other.setId(1L);
        assertThat(testee.sameIdentityAs(other), is(false));
    }
    @Test
    public void testIdentity() {
        assertThat(testee.identity(), is(nullValue()));
        testee.setId(0L);
        assertThat(testee.identity(), is(0L));
    }
    @Test
    public void testCallback() {
        assertThat(testee.isPersisted(), is(false));
        manager.persist(testee);
        manager.flush();
        assertThat(testee.isPersisted(), is(true));
        for (final TestPersistable o : manager.createQuery("select e from TestPersistable e",
            TestPersistable.class).getResultList()) {
            assertThat(o.isPersisted(), is(true));
        }
    }
}
