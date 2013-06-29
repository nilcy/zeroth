// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static zeroth.framework.enterprise.domain.AbstractAuditable_.*;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
/**
 * {@link TestExample_} のユニットテスト
 * @author nilcy
 */
@RunWith(Arquillian.class)
@SuppressWarnings("all")
public class AbstractAuditable_Test {
    @Deployment
    public static JavaArchive deployment() {
        return ArquillianDeployment.defaultDeployment();
    }
    @Test
    public final void test() {
        assertThat(createdBy, is(not(nullValue())));
        assertThat(createdDate, is(not(nullValue())));
        assertThat(lastModifiedBy, is(not(nullValue())));
        assertThat(lastModifiedDate, is(not(nullValue())));
    }
}
