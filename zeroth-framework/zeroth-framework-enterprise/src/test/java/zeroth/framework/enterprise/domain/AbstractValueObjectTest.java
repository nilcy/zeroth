// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 * {@link AbstractValueObject} のユニットテスト
 * @author nilcy
 */
@SuppressWarnings("all")
public class AbstractValueObjectTest {
    @Test
    public final void testAbstractValueObject() {
        assertThat(new AbstractValueObject() {
        }, is(not(nullValue())));
    }
}
