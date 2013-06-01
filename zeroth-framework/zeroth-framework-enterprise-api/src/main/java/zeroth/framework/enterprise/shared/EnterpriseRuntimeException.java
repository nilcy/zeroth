// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.shared;
/**
 * エンタープライズ非キャッチ例外(JavaEE)
 * @author nilcy
 */
public class EnterpriseRuntimeException extends RuntimeException {
    /** 識別番号 */
    private static final long serialVersionUID = 1628775946067528606L;
    /** コンストラクタ */
    public EnterpriseRuntimeException() {
    }
    /**
     * コンストラクタ
     * @param message メッセージ
     */
    public EnterpriseRuntimeException(final String message) {
        super(message);
    }
    /**
     * コンストラクタ
     * @param cause 例外クラス
     */
    public EnterpriseRuntimeException(final Throwable cause) {
        super(cause);
    }
    /**
     * コンストラクタ
     * @param message メッセージ
     * @param cause 例外クラス
     */
    public EnterpriseRuntimeException(final String message, final Throwable cause) {
        super(message, cause);
    }
    /**
     * コンストラクタ
     * @param message メッセージ
     * @param cause 例外クラス
     * @param enableSuppression 抑制するか
     * @param writableStackTrace スタックトレースが書き込み可能であるべきか
     */
    public EnterpriseRuntimeException(final String message, final Throwable cause,
        final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
