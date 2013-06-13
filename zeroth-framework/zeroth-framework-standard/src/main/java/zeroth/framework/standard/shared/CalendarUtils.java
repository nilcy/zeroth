// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.shared;
import java.util.Date;
import org.apache.commons.lang3.time.DateUtils;
/**
 * カレンダーのユーティリティ
 * @author nilcy
 */
public final class CalendarUtils {
    /** １つ前の移動量 */
    private static final int PREV_AMOUNT = -1;
    /** １つ先の移動量 */
    private static final int NEXT_AMOUNT = 1;
    /** 非公開コンストラクタ */
    private CalendarUtils() {
    }
    /**
     * 先週日付の取得
     * @param aDate 基点の日付
     * @return 先週日付
     */
    public static Date prevWeek(final Date aDate) {
        return DateUtils.addWeeks(aDate, PREV_AMOUNT);
    }
    /**
     * 翌週日付の取得
     * @param aDate 基点の日付
     * @return 翌週日付
     */
    public static Date nextWeek(final Date aDate) {
        return DateUtils.addWeeks(aDate, NEXT_AMOUNT);
    }
    /**
     * 先月日付の取得
     * @param aDate 基点の日付
     * @return 先月日付
     */
    public static Date prevMonth(final Date aDate) {
        return DateUtils.addMonths(aDate, PREV_AMOUNT);
    }
    /**
     * 翌月日付の取得
     * @param aDate 基点の日付
     * @return 翌月
     */
    public static Date nextMonth(final Date aDate) {
        return DateUtils.addMonths(aDate, NEXT_AMOUNT);
    }
    /**
     * 前年日付の取得
     * @param aDate 基点の日付
     * @return 先月日付
     */
    public static Date prevYear(final Date aDate) {
        return DateUtils.addYears(aDate, PREV_AMOUNT);
    }
    /**
     * 翌年日付の取得
     * @param aDate 基点の日付
     * @return 翌月
     */
    public static Date nextYear(final Date aDate) {
        return DateUtils.addYears(aDate, NEXT_AMOUNT);
    }
}
