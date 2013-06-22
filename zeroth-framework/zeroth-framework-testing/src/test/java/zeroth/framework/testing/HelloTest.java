// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.testing;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 * {@link Hello} のユニットテスト
 * @author nilcy
 */
@SuppressWarnings("all")
public class HelloTest {
    @Test
    public final void test() {
        assertThat(Hello.sayHello(), is("Hello"));
    }
}
