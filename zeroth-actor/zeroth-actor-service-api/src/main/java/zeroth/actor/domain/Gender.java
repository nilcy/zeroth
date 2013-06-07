// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.domain;
/**
 * 性別
 * @author nilcy
 */
public enum Gender {
    /** 男性 */
    MALE,
    /** 女性 */
    FEMALE;
    /**
     * 文字列値の取得
     * @return 文字列値の取得
     */
    public String getStringValue() {
        return toString();
    }
}
