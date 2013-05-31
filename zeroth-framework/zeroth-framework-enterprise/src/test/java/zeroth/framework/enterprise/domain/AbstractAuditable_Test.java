// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static zeroth.framework.enterprise.domain.AbstractAuditable_.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.googlecode.jeeunit.JeeunitRunner;
import com.googlecode.jeeunit.Transactional;
/**
 * {@link TestExample_} のユニットテスト
 * @author nilcy
 */
@RunWith(JeeunitRunner.class)
@Transactional
@SuppressWarnings("all")
public class AbstractAuditable_Test {
    @Test
    public final void test() {
        assertThat(createdBy, is(not(nullValue())));
        assertThat(createdDate, is(not(nullValue())));
        assertThat(lastModifiedBy, is(not(nullValue())));
        assertThat(lastModifiedDate, is(not(nullValue())));
    }
}
