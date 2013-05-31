// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.shared;
/**
 * 値オブジェクトI/F
 * <p>
 * 値オブジェクトは本I/Fを実装すること。
 * </p>
 * @param <T> 値オブジェクト型
 * @author nilcy
 */
public interface ValueObject<T extends ValueObject<T>> extends DataObject {
    /**
     * 同一性の確認
     * <p>
     * 値オブジェクトの属性値から同一性を確認する。
     * </p>
     * @param aOther 比較する値オブジェクト
     * @return 同一なとき真。同一でないとき偽。
     */
    boolean sameValueAs(T aOther);
}
