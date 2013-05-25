// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.domain;
/**
 * 仕様オブジェクト
 * <p>
 * 論理演算をするための値オブジェクトである。ビジネスルールを「述語」的に表現するときに使用する。
 * </p>
 * @param <T> チェック対象オブジェクト型
 * @author nilcy
 */
public abstract class AbstractSpecification<T> implements Specification<T> {
    @Override
    public abstract boolean isSatisfiedBy(T aObject);
    @Override
    public Specification<T> and(final Specification<T> aSpecification) {
        return new AndSpecification<>(this, aSpecification);
    }
    @Override
    public Specification<T> or(final Specification<T> aSpecification) {
        return new OrSpecification<>(this, aSpecification);
    }
    @Override
    public Specification<T> not(final Specification<T> aSpecification) {
        return new NotSpecification<>(aSpecification);
    }
    @Override
    public Specification<T> xor(final Specification<T> aSpecification) {
        return new XorSpecification<>(this, aSpecification);
    }
    @Override
    public Specification<T> nand(final Specification<T> aSpecification) {
        return new NandSpecification<>(this, aSpecification);
    }
    @Override
    public Specification<T> nor(final Specification<T> aSpecification) {
        return new NorSpecification<>(this, aSpecification);
    }
}
