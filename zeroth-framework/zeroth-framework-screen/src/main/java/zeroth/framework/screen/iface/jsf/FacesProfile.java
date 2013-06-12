// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.screen.iface.jsf;
import java.text.ParseException;
import java.util.Date;
import java.util.ResourceBundle;
import org.apache.commons.lang3.time.DateUtils;
/**
 * Faces Profile.
 * @author nilcy
 */
public final class FacesProfile {
    /** TEST_ACCOUNT. */
    public static final String TEST_ACCOUNT;
    /** MAX_RESULTS. */
    public static final int MAX_RESULTS;
    /** MAX_RESULTS_DL. */
    public static final int MAX_RESULTS_DL;
    /** VIEW_NULL. */
    public static final String VIEW_NULL;
    /** BUNDLE_BASENAME. */
    public static final String BUNDLE_BASENAME;
    /** BATCH_FLUSH. */
    public static final boolean BATCH_FLUSH;
    /** MIN_DATE. */
    public static final Date MIN_DATE;
    /** MAX_DATE. */
    public static final Date MAX_DATE;
    /** CONVERSATION_TIMEOUT. */
    public static final long CONVERSATION_TIMEOUT;
    /** SEPCHR. */
    private static final String SEPCHR = ",";
    /** ISO 8601. */
    private static final String YMD_ISO8601 = "yyyy-MM-dd";
    /** コンストラクタ */
    private FacesProfile() {
        super();
    }
    static {
        final ResourceBundle profile = ResourceBundle.getBundle("faces-profile");
        TEST_ACCOUNT = profile.getString("TEST_ACCOUNT");
        final String[] rangeDates = profile.getString("RANGE_DATE").split(SEPCHR);
        try {
            MIN_DATE = DateUtils.parseDateStrictly(rangeDates[0], YMD_ISO8601);
            MAX_DATE = DateUtils.parseDateStrictly(rangeDates[1], YMD_ISO8601);
        } catch (final ParseException e) {
            throw new RuntimeException(e);
        }
        final String[] maxResults = profile.getString("MAX_RESULTS").split(SEPCHR);
        MAX_RESULTS = Integer.parseInt(maxResults[0]);
        MAX_RESULTS_DL = Integer.parseInt(maxResults[1]);
        VIEW_NULL = profile.getString("VIEW_NULL");
        BUNDLE_BASENAME = profile.getString("BUNDLE_BASENAME");
        BATCH_FLUSH = Boolean.valueOf(profile.getString("BATCH_FLUSH")).booleanValue();
        CONVERSATION_TIMEOUT = Long.valueOf(profile.getString("CONVERSATION_TIMEOUT")).longValue();
    }
}
