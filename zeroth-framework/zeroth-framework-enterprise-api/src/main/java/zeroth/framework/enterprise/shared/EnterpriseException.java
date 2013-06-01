// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.shared;
/**
 * エンタープライズキャッチ例外(JavaEE)
 * @author nilcy
 */
public class EnterpriseException extends Exception {
    /** 識別番号 */
    private static final long serialVersionUID = -2800101543289045004L;
    /** コンストラクタ */
    public EnterpriseException() {
    }
    /**
     * コンストラクタ
     * @param message メッセージ
     */
    public EnterpriseException(final String message) {
        super(message);
    }
    /**
     * コンストラクタ
     * @param cause 例外クラス
     */
    public EnterpriseException(final Throwable cause) {
        super(cause);
    }
    /**
     * コンストラクタ
     * @param message メッセージ
     * @param cause 例外クラス
     */
    public EnterpriseException(final String message, final Throwable cause) {
        super(message, cause);
    }
    /**
     * コンストラクタ
     * @param message メッセージ
     * @param cause 例外クラス
     * @param enableSuppression 抑制するか
     * @param writableStackTrace スタックトレースが書き込み可能であるべきか
     */
    public EnterpriseException(final String message, final Throwable cause,
        final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
