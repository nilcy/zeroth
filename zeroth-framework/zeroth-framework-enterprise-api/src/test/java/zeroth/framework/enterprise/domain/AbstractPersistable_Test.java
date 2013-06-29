// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static zeroth.framework.enterprise.domain.AbstractPersistable_.*;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
/**
 * {@link AbstractPersistable_} のユニットテスト
 * @author nilcy
 */
@RunWith(Arquillian.class)
@SuppressWarnings("all")
public class AbstractPersistable_Test {
    @Deployment
    public static JavaArchive deployment() {
        return ArquillianDeployment.defaultDeployment();
    }
    @Test
    public final void test() {
        assertThat(id, is(not(nullValue())));
    }
}
