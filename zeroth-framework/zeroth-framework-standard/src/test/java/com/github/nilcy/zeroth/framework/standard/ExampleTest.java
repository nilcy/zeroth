// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package com.github.nilcy.zeroth.framework.standard;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 * Test {@link Example}.
 * @author nilcy
 */
@SuppressWarnings("all")
public class ExampleTest {
    Example testee = new Example();
    @Test
    public void testSayHello() {
        assertThat(this.testee.sayHello(), is("Hello"));
    }
    private class Example {
        String sayHello() {
            return "Hello";
        }
    }
}