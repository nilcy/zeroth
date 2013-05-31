// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.domain;
import zeroth.framework.standard.shared.DataObject;
/**
 * 参照オブジェクトI/F (エンティティI/F)
 * <p>
 * 参照オブジェクトは本I/Fを実装すること。
 * </p>
 * @param <T> 参照オブジェクト型
 * @param <ID> 識別子オブジェクト型
 * @author nilcy
 */
public interface ReferenceObject<T extends ReferenceObject<T, ID>, ID> extends DataObject {
    /**
     * 同一性の確認
     * <p>
     * 参照オブジェクトの識別子から同一性を確認する。
     * </p>
     * @param object 比較する参照オブジェクト
     * @return 同一なとき真。同一でないとき偽。
     */
    boolean sameIdentityAs(T object);
    /**
     * 識別子
     * @return 識別子
     */
    ID identity();
}
