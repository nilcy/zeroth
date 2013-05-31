// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.shared;
/**
 * スタンダードキャッチ例外(JavaSE)
 * @author nilcy
 */
public class StandardException extends Exception {
    /** 識別番号 */
    private static final long serialVersionUID = -2800101543289045004L;
    /** コンストラクタ */
    public StandardException() {
    }
    /**
     * コンストラクタ
     * @param message メッセージ
     */
    public StandardException(final String message) {
        super(message);
    }
    /**
     * コンストラクタ
     * @param cause 例外クラス
     */
    public StandardException(final Throwable cause) {
        super(cause);
    }
    /**
     * コンストラクタ
     * @param message メッセージ
     * @param cause 例外クラス
     */
    public StandardException(final String message, final Throwable cause) {
        super(message, cause);
    }
    /**
     * コンストラクタ
     * @param message メッセージ
     * @param cause 例外クラス
     * @param enableSuppression 抑制するか
     * @param writableStackTrace スタックトレースが書き込み可能であるべきか
     */
    public StandardException(final String message, final Throwable cause,
        final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
