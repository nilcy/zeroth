// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import java.util.Collection;
import java.util.logging.Logger;
import javax.inject.Inject;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.googlecode.jeeunit.JeeunitRunner;
import com.googlecode.jeeunit.Transactional;
/**
 * {@link AbstractSimpleRepositoryImpl} のユニットテスト
 * @author nilcy
 */
@RunWith(JeeunitRunner.class)
@Transactional
@SuppressWarnings("all")
public class AbstractSimpleRepositoryImplTest {
    @Inject
    private TestExampleSimpleRepository testee;
    @Inject
    private Logger log;
    @Test
    public final void test() {
        // エンティティ保存
        final TestExample ex00 = new TestExample("code-00");
        this.testee.save(ex00);
        assertThat(ex00.getId(), is(not(nullValue())));
        assertThat(ex00.getVersion(), is(not(nullValue())));
        // エンティティ検索(ID)
        final TestExample exId = this.testee.find(01L);
        assertThat(exId.getId(), is(ex00.getId()));
        assertThat(exId.getVersion(), is(ex00.getVersion()));
        // エンティティ検索(単一)
        final TestExample exOne = this.testee.findOne(new TestExampleValue("code-00"));
        assertThat(exOne.getId(), is(ex00.getId()));
        assertThat(exOne.getVersion(), is(ex00.getVersion()));
        // エンティティ検索(複数)
        final Collection<TestExample> exMany = this.testee
            .findMany(new TestExampleValue("code-00"));
        assertThat(exMany.size(), is(1));
        final TestExample exMany1 = exMany.iterator().next();
        assertThat(exMany1.getId(), is(ex00.getId()));
        assertThat(exMany1.getVersion(), is(ex00.getVersion()));
        // エンティティ削除
        this.testee.delete(exId);
    }
}
