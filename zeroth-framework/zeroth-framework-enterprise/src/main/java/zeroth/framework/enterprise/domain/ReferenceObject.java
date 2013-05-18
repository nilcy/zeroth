// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
import zeroth.framework.standard.shared.DataObject;
/**
 * 参照オブジェクトI/F
 * <p>
 * 参照オブジェクトは本I/Fを実装すること。 シリアライズとソートが可能である。
 * </p>
 * @param <T> 参照オブジェクト型
 * @author nilcy
 */
public interface ReferenceObject<T extends ReferenceObject<T>> extends DataObject<T> {
    /**
     * IDの取得
     * @return ID
     */
    Long getId();
    /**
     * IDの設定
     * @param aId ID
     */
    void setId(Long aId);
}
