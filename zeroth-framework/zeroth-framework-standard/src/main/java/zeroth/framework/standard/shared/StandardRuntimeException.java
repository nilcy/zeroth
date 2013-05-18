// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.shared;
/**
 * 基本の非キャッチ例外
 * @author nilcy
 */
public class StandardRuntimeException extends RuntimeException {
    /** 識別番号 */
    private static final long serialVersionUID = 1628775946067528606L;
    /** コンストラクタ */
    public StandardRuntimeException() {
    }
    /**
     * コンストラクタ
     * @param aMessage メッセージ
     */
    public StandardRuntimeException(final String aMessage) {
        super(aMessage);
    }
    /**
     * コンストラクタ
     * @param aCause 例外クラス
     */
    public StandardRuntimeException(final Throwable aCause) {
        super(aCause);
    }
    /**
     * コンストラクタ
     * @param aMessage メッセージ
     * @param aCause 例外クラス
     */
    public StandardRuntimeException(final String aMessage, final Throwable aCause) {
        super(aMessage, aCause);
    }
    /**
     * コンストラクタ
     * @param aMessage メッセージ
     * @param aCause 例外クラス
     * @param aEnableSuppression 抑制するか
     * @param aWritableStackTrace スタックトレースが書き込み可能であるべきか
     */
    public StandardRuntimeException(final String aMessage, final Throwable aCause,
        final boolean aEnableSuppression, final boolean aWritableStackTrace) {
        super(aMessage, aCause, aEnableSuppression, aWritableStackTrace);
    }
}
