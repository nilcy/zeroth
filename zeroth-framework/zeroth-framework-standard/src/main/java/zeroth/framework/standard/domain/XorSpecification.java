// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.domain;
/**
 * 排他的論理和(XOR)仕様オブジェクト
 * @param <T> チェック対象オブジェクト型
 * @author nilcy
 */
public class XorSpecification<T> extends AbstractSpecification<T> {
    /** 仕様オブジェクト#1 */
    private final Specification<T> spec1;
    /** 仕様オブジェクト#2 */
    private final Specification<T> spec2;
    /**
     * 排他的論理和(XOR)仕様のコンストラクタ
     * @param spec1 仕様オブジェクト#1
     * @param spec2 仕様オブジェクト#2
     */
    public XorSpecification(final Specification<T> spec1, final Specification<T> spec2) {
        this.spec1 = spec1;
        this.spec2 = spec2;
    }
    /** {@inheritDoc} */
    @Override
    public boolean isSatisfiedBy(final T object) {
        return (this.spec1.isSatisfiedBy(object) && !this.spec2.isSatisfiedBy(object))
            || (!this.spec1.isSatisfiedBy(object) && this.spec2.isSatisfiedBy(object));
    }
}
