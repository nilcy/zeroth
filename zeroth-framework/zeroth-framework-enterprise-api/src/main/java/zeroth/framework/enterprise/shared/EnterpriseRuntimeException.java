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
     * @param aMessage メッセージ
     */
    public EnterpriseRuntimeException(final String aMessage) {
        super(aMessage);
    }
    /**
     * コンストラクタ
     * @param aCause 例外クラス
     */
    public EnterpriseRuntimeException(final Throwable aCause) {
        super(aCause);
    }
    /**
     * コンストラクタ
     * @param aMessage メッセージ
     * @param aCause 例外クラス
     */
    public EnterpriseRuntimeException(final String aMessage, final Throwable aCause) {
        super(aMessage, aCause);
    }
    /**
     * コンストラクタ
     * @param aMessage メッセージ
     * @param aCause 例外クラス
     * @param aEnableSuppression 抑制するか
     * @param aWritableStackTrace スタックトレースが書き込み可能であるべきか
     */
    public EnterpriseRuntimeException(final String aMessage, final Throwable aCause,
        final boolean aEnableSuppression, final boolean aWritableStackTrace) {
        super(aMessage, aCause, aEnableSuppression, aWritableStackTrace);
    }
}
