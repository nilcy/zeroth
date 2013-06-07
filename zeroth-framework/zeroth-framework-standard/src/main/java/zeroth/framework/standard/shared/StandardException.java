// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.shared;
import java.util.LinkedHashMap;
import java.util.Map;
/**
 * スタンダードキャッチ例外(JavaSE)
 * @author nilcy
 */
public class StandardException extends Exception {
    /** 製品番号 */
    private static final long serialVersionUID = -8840078977353262309L;
    /** 例外マップ */
    private final Map<String, Object[]> causeMap;
    /**
     * コンストラクタ
     * <p>
     * 引数をもとに {@link #causeMap} を初期化する。
     * </p>
     * @param key キー
     * @param values バリュー配列
     */
    public StandardException(final String key, final Object... values) {
        causeMap = new LinkedHashMap<>();
        causeMap.put(key, values);
    }
    /**
     * コンストラクタ
     * @param causeMap {@link #causeMap}
     */
    public StandardException(final Map<String, Object[]> causeMap) {
        this.causeMap = causeMap;
    }
    /**
     * {@link #causeMap} の取得
     * @return {@link #causeMap}
     */
    public final Map<String, Object[]> getCauseMap() {
        return causeMap;
    }
}
