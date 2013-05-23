// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.infra.persistence;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static zeroth.framework.enterprise.domain.TestExampleObject_.*;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.persistence.LockModeType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.googlecode.jeeunit.JeeunitRunner;
import com.googlecode.jeeunit.Transactional;
import zeroth.framework.enterprise.domain.TestExampleObject;
/**
 * {@link GenericDaoImpl} のユニットテスト
 * @author nilcy
 */
@RunWith(JeeunitRunner.class)
@Transactional
@SuppressWarnings("all")
public class GenericDaoImplTest {
    @Inject
    private GenericaDao<TestExampleObject, Long> testee;
    @Inject
    private Logger log;
    @Test
    public void testCRUD() {
        final TestExampleObject e01 = new TestExampleObject("code01");
        this.testee.create(e01);
        assertThat(e01.getId(), is(1L));
        assertThat(e01.getVersion(), is(1L));
        assertThat(this.testee.contains(e01), is(true));
        final TestExampleObject e01r = this.testee.read(1L);
        assertThat(e01r, is(e01));
        e01r.setCode("code01#1");
        this.testee.lock(e01r, LockModeType.PESSIMISTIC_READ);
        this.testee.flush();
        this.testee.refresh(e01r);
        this.testee.refresh(e01r, LockModeType.PESSIMISTIC_WRITE);
        this.testee.detach(e01r);
        e01r.setCode("code01#2");
        this.testee.update(e01r);
        this.testee.delete(this.testee.read(e01r.getId()));
        assertThat(this.testee.read(1L, LockModeType.OPTIMISTIC), is(nullValue()));
    }
    @Test
    public void testCriteria() {
        final CriteriaBuilder b = this.testee.builder();
        final CriteriaQuery<TestExampleObject> q = this.testee.query();
        final Root<TestExampleObject> r = this.testee.root();
        this.testee.create(new TestExampleObject("code01"));
        this.testee.create(new TestExampleObject("code02"));
        final TypedQuery<TestExampleObject> typedQuery = this.testee
            .createQuery(q.select(r).where(b.equal(r.get(code), "code01"))
                .orderBy(b.asc(r.get(code))).groupBy(r.get(code)));
        for (final TestExampleObject e : typedQuery.getResultList()) {
            this.log.info("TestExampleObject >> " + e.toString());
        }
    }
}
