// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.shared;
/**
 * 基本のキャッチ例外
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
     * @param aMessage メッセージ
     */
    public StandardException(final String aMessage) {
        super(aMessage);
    }
    /**
     * コンストラクタ
     * @param aCause 例外クラス
     */
    public StandardException(final Throwable aCause) {
        super(aCause);
    }
    /**
     * コンストラクタ
     * @param aMessage メッセージ
     * @param aCause 例外クラス
     */
    public StandardException(final String aMessage, final Throwable aCause) {
        super(aMessage, aCause);
    }
    /**
     * コンストラクタ
     * @param aMessage メッセージ
     * @param aCause 例外クラス
     * @param aEnableSuppression 抑制するか
     * @param aWritableStackTrace スタックトレースが書き込み可能であるべきか
     */
    public StandardException(final String aMessage, final Throwable aCause,
        final boolean aEnableSuppression, final boolean aWritableStackTrace) {
        super(aMessage, aCause, aEnableSuppression, aWritableStackTrace);
    }
}
