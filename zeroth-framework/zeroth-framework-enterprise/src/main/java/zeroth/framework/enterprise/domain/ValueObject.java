// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
import zeroth.framework.standard.shared.DataObject;
/**
 * 値オブジェクトI/F
 * <p>
 * 値オブジェクトは本I/Fを実装すること。 シリアライズとソートが可能である。
 * </p>
 * @param <T> 値オブジェクト型
 * @author nilcy
 */
public interface ValueObject<T extends ValueObject<T>> extends DataObject<T> {
}
