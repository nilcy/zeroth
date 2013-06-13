// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.domain;
/**
 * 否定(NOT)仕様オブジェクト
 * @param <T> チェック対象オブジェクト型
 * @author nilcy
 */
public class NotSpecification<T> extends AbstractSpecification<T> {
    /** 仕様オブジェクト */
    private final Specification<T> spec;
    /**
     * 否定(NOT)仕様のコンストラクタ
     * @param spec 仕様オブジェクト
     */
    public NotSpecification(final Specification<T> spec) {
        this.spec = spec;
    }
    /** {@inheritDoc} */
    @Override
    public boolean isSatisfiedBy(final T object) {
        return !this.spec.isSatisfiedBy(object);
    }
}
