// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.screen;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 * Test {@link Example}.
 * @author nilcy
 */
@SuppressWarnings("all")
public class ExampleTest {
    @Test
    public void testSayHello() {
        assertThat(Example.sayHello(), is("Hello"));
    }
}
