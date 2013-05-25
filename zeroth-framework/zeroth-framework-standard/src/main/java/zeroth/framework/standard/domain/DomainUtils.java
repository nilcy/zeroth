// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.domain;
import org.apache.commons.lang3.ObjectUtils;
/**
 * ドメインユーティリティ
 * @author nilcy
 */
public class DomainUtils {
    /** コンストラクタ */
    private DomainUtils() {
    }
    /**
     * NULLセーフ変換
     * @param aActual 対象オブジェクト
     * @param aSafe NULLセーフオブジェクト
     * @param <T> 対象オブジェクト型
     * @return 対象オブジェクトがNULLのときNULLセーフオブジェクト
     * @see ObjectUtils#defaultIfNull(Object, Object)
     */
    public static <T> T nullSafe(final T aActual, final T aSafe) {
        return ObjectUtils.defaultIfNull(aActual, aSafe);
    }
}
