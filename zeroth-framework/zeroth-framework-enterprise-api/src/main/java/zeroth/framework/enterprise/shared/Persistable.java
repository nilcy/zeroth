// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.shared;
import java.io.Serializable;
/**
 * 永続可能エンティティI/F
 * @param <ID> 識別子オブジェクト型
 * @author nilcy
 */
public interface Persistable<ID extends Serializable> extends Serializable {
    /**
     * 識別子
     * @return 識別子
     */
    Object identity();
    /**
     * 永続済チェック
     * @return 永続化する前は偽。永続化された後は真。
     */
    boolean isPersisted();
}
