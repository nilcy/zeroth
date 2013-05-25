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
 * {@link zeroth.framework.standard.domain.NotSpecification} のユニットテスト
 * @author nilcy
 */
@SuppressWarnings("all")
public class NotSpecificationTest {
    private final TrueSpecification trueSpec = new TrueSpecification();
    private final FalseSpecification falseSpec = new FalseSpecification();
    @Test
    public final void testIsSatisfiedBy() {
        assertThat(new NotSpecification<Object>(this.trueSpec).isSatisfiedBy(new Object()),
            is(false));
        assertThat(new NotSpecification<Object>(this.falseSpec).isSatisfiedBy(new Object()),
            is(true));
    }
}
