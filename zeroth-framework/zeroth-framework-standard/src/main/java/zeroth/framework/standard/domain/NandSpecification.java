// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.domain;
/**
 * 否定論理積(NAND)仕様オブジェクト
 * @param <T> チェック対象オブジェクト型
 * @author nilcy
 */
public class NandSpecification<T> extends AbstractSpecification<T> {
    /** 仕様オブジェクト#1 */
    private final Specification<T> specification1;
    /** 仕様オブジェクト#2 */
    private final Specification<T> specification2;
    /**
     * コンストラクタ
     * @param aSpecification1 仕様オブジェクト#1
     * @param aSpecification2 仕様オブジェクト#2
     */
    public NandSpecification(final Specification<T> aSpecification1,
        final Specification<T> aSpecification2) {
        this.specification1 = aSpecification1;
        this.specification2 = aSpecification2;
    }
    @Override
    public boolean isSatisfiedBy(final T aObject) {
        return !(this.specification1.isSatisfiedBy(aObject) && this.specification2
            .isSatisfiedBy(aObject));
    }
}
