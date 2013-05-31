// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.domain;
/**
 * 仕様オブジェクトI/F
 * <p>
 * 論理演算をするための値オブジェクトである。ビジネスルールを「述語」的に表現するときに使用する。
 * </p>
 * @param <T> チェック対象オブジェクト型
 * @author nilcy
 */
public interface Specification<T> {
    /**
     * 仕様チェック
     * @param object チェック対象オブジェクト
     * @return {@code aObject} が仕様を満たすとき {@code true}
     */
    boolean isSatisfiedBy(T object);
    /**
     * 論理積(AND)仕様の作成
     * @param spec 仕様オブジェクト
     * @return 論理積(AND)仕様
     */
    Specification<T> and(Specification<T> spec);
    /**
     * 論理和(OR)仕様の作成
     * @param spec 仕様オブジェクト
     * @return 論理和(OR)仕様
     */
    Specification<T> or(Specification<T> spec);
    /**
     * 否定(NOT)仕様の作成
     * @param spec 仕様オブジェクト
     * @return 否定(NOT)仕様
     */
    Specification<T> not(Specification<T> spec);
    /**
     * 排他的論理和(XOR)仕様の作成
     * @param spec 仕様オブジェクト
     * @return 排他的論理和(XOR)仕様
     */
    Specification<T> xor(Specification<T> spec);
    /**
     * 否定論理積(NAND)仕様の作成
     * @param spec 仕様オブジェクト
     * @return 否定論理積(NAND)仕様
     */
    Specification<T> nand(Specification<T> spec);
    /**
     * 否定論理和(NOR)仕様の作成
     * @param spec 仕様オブジェクト
     * @return 否定論理和(NOR)仕様
     */
    Specification<T> nor(Specification<T> spec);
}
