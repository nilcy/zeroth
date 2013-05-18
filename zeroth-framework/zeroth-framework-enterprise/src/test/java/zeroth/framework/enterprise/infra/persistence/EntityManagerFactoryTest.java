// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.infra.persistence;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.googlecode.jeeunit.JeeunitRunner;
import com.googlecode.jeeunit.Transactional;
/**
 * {@link EntityManagerFactory}
 * @author nilcy
 */
@RunWith(JeeunitRunner.class)
@Transactional
@SuppressWarnings("all")
public class EntityManagerFactoryTest {
    @Inject
    @PrimaryEntityManager
    private EntityManager entityManager1st;
    @Inject
    @SecondaryEntityManager
    private EntityManager entityManager2nd;
    @Test
    public void test() {
        assertThat(this.entityManager1st, is(not(nullValue())));
        assertThat(this.entityManager2nd, is(not(nullValue())));
    }
}
