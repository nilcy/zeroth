// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.domain;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 * {@link zeroth.framework.standard.domain.XorSpecification} のユニットテスト
 * @author nilcy
 */
@SuppressWarnings("all")
public class XorSpecificationTest {
    private final TrueSpecification trueSpec = new TrueSpecification();
    private final FalseSpecification falseSpec = new FalseSpecification();
    @Test
    public final void testIsSatisfiedBy() {
        assertThat(new XorSpecification<Object>(trueSpec, trueSpec).isSatisfiedBy(new Object()),
            is(false));
        assertThat(new XorSpecification<Object>(falseSpec, trueSpec).isSatisfiedBy(new Object()),
            is(true));
        assertThat(new XorSpecification<Object>(trueSpec, falseSpec).isSatisfiedBy(new Object()),
            is(true));
        assertThat(new XorSpecification<Object>(falseSpec, falseSpec).isSatisfiedBy(new Object()),
            is(false));
    }
}
