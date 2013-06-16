// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.domain.parts;
import java.util.Arrays;
/**
 * 権限
 * @author nilcy
 */
public enum Auth {
    /** 監督者 */
    SUPERVISOR,
    /** 管理者 */
    ADMINISTRATOR,
    /** 所属長 */
    MANAGER,
    /** 推進者 */
    LEADER,
    /** 担当者 */
    MEMBER,
    /** 支援者 */
    SUPPORTER,
    /** 使用者 */
    USER;
    /** 職名権限の配列 */
    private static final Auth[] TITLE_AUTHS = new Auth[] { MANAGER, LEADER, MEMBER };
    /** 職員権限の配列 */
    private static final Auth[] STAFF_AUTHS = new Auth[] { SUPERVISOR, ADMINISTRATOR, SUPPORTER };
    /**
     * {@link #TITLE_AUTHS} の取得
     * @return {@link #TITLE_AUTHS}
     */
    public static Auth[] valuesOfTitle() {
        return TITLE_AUTHS;
    }
    /**
     * {@link #STAFF_AUTHS} の取得
     * @return {@link #STAFF_AUTHS}
     */
    public static Auth[] valuesOfStaff() {
        return STAFF_AUTHS;
    }
    /**
     * 職名権限の含有チェック
     * @return 含有するとき真。含有されないとき偽。
     */
    public boolean isTitleAuth() {
        return Arrays.asList(TITLE_AUTHS).contains(this);
    }
    /**
     * 職員権限の含有チェック
     * @return 含有するとき真。含有されないとき偽。
     */
    public boolean isStaffAuth() {
        return Arrays.asList(STAFF_AUTHS).contains(this);
    }
}
