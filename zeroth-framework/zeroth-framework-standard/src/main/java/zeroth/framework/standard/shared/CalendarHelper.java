// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.shared;
import java.util.Date;
import org.apache.commons.lang3.time.DateUtils;
/**
 * Calendar helper.
 * @author nilcy
 */
public final class CalendarHelper {
    /** Constructor. */
    private CalendarHelper() {
        super();
    }
    /**
     * next week.
     * @param aDate date
     * @return next week
     */
    public static Date nextWeek(final Date aDate) {
        return DateUtils.addWeeks(aDate, 1);
    }
}
