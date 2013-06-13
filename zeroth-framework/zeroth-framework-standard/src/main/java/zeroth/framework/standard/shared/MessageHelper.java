// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.shared;
import java.text.MessageFormat;
import java.util.ResourceBundle;
/**
 * Message helper.
 * @author nilcy
 */
public final class MessageHelper {
    /** resource bundle. */
    private static final ResourceBundle MESSAGE = ResourceBundle
        .getBundle("com.kuzumeji.framework-message");
    /** Constructor. */
    private MessageHelper() {
    }
    /**
     * build.
     * @param key key
     * @param objects Objects
     * @return message
     */
    public static String build(final String key, final Object... objects) {
        return MessageFormat.format(MESSAGE.getString(key), objects);
    }
}
