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
import zeroth.framework.standard.shared.PageRequest;
import zeroth.framework.standard.shared.Sort.Direction;
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
    private TestExampleFactory entityFactory;
    @Inject
    private TestExampleValueFactory valueFactory;
    @Inject
    private Logger log;
    @Test
    public final void test() throws ConstraintsException {
        // エンティティ保存
        final TestExample ex00 = entityFactory.create("code-00");
        testee.save(ex00);
        assertThat(ex00.getId(), is(not(nullValue())));
        assertThat(ex00.getVersion(), is(not(nullValue())));
        // エンティティ検索
        final TestExample exId = testee.find(01L);
        assertThat(exId.getId(), is(ex00.getId()));
        // 単一エンティティ検索
        final TestExampleValue filterOne = valueFactory.create("code-00");
        final TestExample exOne = testee.findOne(filterOne);
        assertThat(exOne.getId(), is(ex00.getId()));
        assertThat(exOne.getVersion(), is(ex00.getVersion()));
        // 複数エンティティ検索
        final PageRequest pageRequest = new PageRequest(1, 10, Direction.ASC, "code");
        final TestExampleValue filterMany = valueFactory.create("code-00", pageRequest);
        filterMany.setPageRequest(new PageRequest(1, 10, Direction.ASC, "code"));
        final Collection<TestExample> exMany = testee.findMany(filterMany);
        assertThat(exMany.size(), is(1));
        final TestExample exMany1 = exMany.iterator().next();
        assertThat(exMany1.getId(), is(ex00.getId()));
        assertThat(exMany1.getVersion(), is(ex00.getVersion()));
        // エンティティ件数
        final TestExampleValue filterCount = valueFactory.create("code-00");
        final long count = testee.count(filterCount);
        assertThat(count, is(1L));
        // エンティティ削除
        testee.delete(exId);
    }
}
