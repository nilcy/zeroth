// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.domain;
import java.io.Serializable;
/**
 * 永続可能I/F
 * @param <ID> 識別子オブジェクト型
 * @author nilcy
 */
public interface Persistable<ID extends Serializable> extends Serializable {
    /**
     * 識別子
     * @return 識別子
     */
    ID identity();
    /**
     * 永続前チェック
     * @return 永続化する前は真。永続化された後は偽。
     */
    boolean isNew();
}
