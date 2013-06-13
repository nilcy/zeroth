// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.shared;
import java.text.MessageFormat;
import java.util.ResourceBundle;
/**
 * メッセージのユーティリティ
 * @author nilcy
 */
public final class MessageUtils {
    /** メッセージバンドル */
    private static final ResourceBundle MESSAGE = ResourceBundle
        .getBundle("zeroth.framework.standard.bundle.bundle");
    /** 非公開コンストラクタ */
    private MessageUtils() {
    }
    /**
     * メッセージの構築
     * @param key メッセージバンドルのキー
     * @param objects 展開オブジェクト
     * @return メッセージ
     */
    public static String build(final String key, final Object... objects) {
        return MessageFormat.format(MESSAGE.getString(key), objects);
    }
}
