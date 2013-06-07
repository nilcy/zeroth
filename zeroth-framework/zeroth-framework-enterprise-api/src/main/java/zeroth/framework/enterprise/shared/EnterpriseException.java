// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.shared;
import java.util.Map;
import zeroth.framework.standard.shared.StandardException;
/**
 * エンタープライズキャッチ例外(JavaEE)
 * @author nilcy
 */
public class EnterpriseException extends StandardException {
    /** 識別番号 */
    private static final long serialVersionUID = -2800101543289045004L;
    /**
     * コンストラクタ
     * @param key キー
     * @param values バリュー配列
     * @see StandardException#StandardException(String, Object...)
     */
    public EnterpriseException(final String key, final Object... values) {
        super(key, values);
    }
    /**
     * コンストラクタ
     * @param causeMap {@link StandardException#getCauseMap()}
     */
    public EnterpriseException(final Map<String, Object[]> causeMap) {
        super(causeMap);
    }
}
