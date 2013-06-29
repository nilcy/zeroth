// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.shared;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import java.util.logging.Logger;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
/**
 * {@link LoggerProducer}
 * @author nilcy
 */
@RunWith(Arquillian.class)
@SuppressWarnings("all")
public class LoggerProducerTest {
    @Inject
    private Logger testee;
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
            .addPackages(true, "zeroth.framework.standard", "zeroth.framework.enterprise.shared")
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }
    @Test
    public void test() {
        assertThat(testee, is(not(nullValue())));
        testee.finest("FINEST");
        testee.finer("FINER");
        testee.fine("FINE");
        testee.config("CONFIG");
        testee.info("INFO");
        testee.warning("WARNING");
        testee.severe("SEVERE");
    }
}
