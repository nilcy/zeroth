// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.infra.persistence;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static zeroth.framework.enterprise.domain.TestExample_.*;
import java.util.Collection;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.persistence.LockModeType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.googlecode.jeeunit.JeeunitRunner;
import com.googlecode.jeeunit.Transactional;
import zeroth.framework.enterprise.domain.TestExample;
/**
 * {@link QueryPersistenceServiceImpl} のユニットテスト
 * @author nilcy
 */
@RunWith(JeeunitRunner.class)
@Transactional
@SuppressWarnings("all")
public class QueryPersistenceServiceImplTest {
    // /** 基礎エンティティマネージャ */
    // @Inject
    // @PrimaryEntityManager
    // private EntityManager manager;
    @Inject
    private QueryPersistenceService<TestExample, Long> testee;
    // private TestExamplePersistenceService testee;
    @Inject
    private Logger log;
    // @Before
    // public void before() {
    // testee.setup(manager);
    // }
    @Test
    public void testCRUD() {
        final TestExample e01 = new TestExample("code01");
        testee.persist(e01);
        assertThat(e01.getId(), is(1L));
        assertThat(testee.contains(e01), is(true));
        final TestExample e01r = testee.find(1L);
        assertThat(e01r, is(e01));
        e01r.setCode("code01#1");
        testee.lock(e01r, LockModeType.PESSIMISTIC_READ);
        testee.flush();
        testee.refresh(e01r);
        testee.refresh(e01r, LockModeType.PESSIMISTIC_WRITE);
        testee.detach(e01r);
        e01r.setCode("code01#2");
        testee.merge(e01r);
        testee.remove(testee.find(e01r.getId()));
        assertThat(testee.find(1L, LockModeType.OPTIMISTIC), is(nullValue()));
    }
    @Test
    public void testCriteria() {
        final CriteriaBuilder b = testee.builder();
        final Root<TestExample> r = testee.root();
        testee.persist(new TestExample("code01"));
        testee.persist(new TestExample("code02"));
        testee.query().select(r).where(b.equal(r.get(code), "code01")).orderBy(b.asc(r.get(code)));
        final Collection<TestExample> testExamples = testee.createQuery().getResultList();
        assertThat(testExamples.size(), is(1));
        for (final TestExample e : testExamples) {
            assertThat(e.getCode(), is("code01"));
            log.info("TestExampleObject >> " + e.toString());
        }
    }
}
