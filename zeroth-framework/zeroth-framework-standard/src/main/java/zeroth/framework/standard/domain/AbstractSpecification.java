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
    /** {@inheritDoc} */
    @Override
    public abstract boolean isSatisfiedBy(T object);
    /** {@inheritDoc} */
    @Override
    public Specification<T> and(final Specification<T> spec) {
        return new AndSpecification<>(this, spec);
    }
    /** {@inheritDoc} */
    @Override
    public Specification<T> or(final Specification<T> spec) {
        return new OrSpecification<>(this, spec);
    }
    /** {@inheritDoc} */
    @Override
    public Specification<T> not(final Specification<T> spec) {
        return new NotSpecification<>(spec);
    }
    /** {@inheritDoc} */
    @Override
    public Specification<T> xor(final Specification<T> aSpecification) {
        return new XorSpecification<>(this, aSpecification);
    }
    /** {@inheritDoc} */
    @Override
    public Specification<T> nand(final Specification<T> aSpecification) {
        return new NandSpecification<>(this, aSpecification);
    }
    /** {@inheritDoc} */
    @Override
    public Specification<T> nor(final Specification<T> aSpecification) {
        return new NorSpecification<>(this, aSpecification);
    }
}
