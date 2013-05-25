// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.domain;
@SuppressWarnings("all")
public class FalseSpecification extends AbstractSpecification<Object> {
    @Override
    public boolean isSatisfiedBy(final Object o) {
        return false;
    }
}