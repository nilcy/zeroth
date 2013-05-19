// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static zeroth.framework.enterprise.domain.TestExampleObject_.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.googlecode.jeeunit.JeeunitRunner;
import com.googlecode.jeeunit.Transactional;
/**
 * {@link TestExampleObject_} のユニットテスト
 * @author nilcy
 */
@RunWith(JeeunitRunner.class)
@Transactional
@SuppressWarnings("all")
public class AbstractRevisedObject_Test {
    @Test
    public final void test() {
        assertThat(created, is(not(nullValue())));
        assertThat(updated, is(not(nullValue())));
    }
}
