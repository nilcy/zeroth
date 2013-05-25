// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.domain;
/**
 * 論理積(AND)仕様オブジェクト
 * @param <T> チェック対象オブジェクト型
 * @author nilcy
 */
public class AndSpecification<T> extends AbstractSpecification<T> {
    /** 仕様オブジェクト#1 */
    private final Specification<T> specification1;
    /** 仕様オブジェクト#2 */
    private final Specification<T> specification2;
    /**
     * 論理積(AND)仕様のコンストラクタ
     * @param aSpecification1 仕様オブジェクト#1
     * @param aSpecification2 仕様オブジェクト#2
     */
    public AndSpecification(final Specification<T> aSpecification1,
        final Specification<T> aSpecification2) {
        this.specification1 = aSpecification1;
        this.specification2 = aSpecification2;
    }
    @Override
    public boolean isSatisfiedBy(final T aObject) {
        return this.specification1.isSatisfiedBy(aObject)
            && this.specification2.isSatisfiedBy(aObject);
    }
}
