// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.shared;
import java.io.Serializable;
/**
 * データオブジェクトI/F
 * <p>
 * 参照オブジェクトと値オブジェクトは本I/Fを実装すること。 シリアライズとソートが可能である。
 * </p>
 * @param <T> データオブジェクト型
 * @author nilcy
 */
public interface DataObject<T extends DataObject<T>> extends Serializable, Cloneable, Comparable<T> {
}