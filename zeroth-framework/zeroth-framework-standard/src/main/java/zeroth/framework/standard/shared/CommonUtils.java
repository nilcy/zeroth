// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.shared;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.Validate;
/**
 * レイヤ共通ユーティリティ
 * @author nilcy
 */
public class CommonUtils {
    /** コンストラクタ */
    private CommonUtils() {
    }
    /**
     * 非NULLチェック
     * @param object チェック対象オブジェクト
     * @return 非NULLオブジェクト
     * @throws NullPointerException チェック対象オブジェクトがNULLのとき
     */
    public static <T> T notNull(final T object) {
        return Validate.notNull(object);
    }
    /**
     * NULLセーフ変換
     * @param object 対象オブジェクト
     * @param defaultValue NULLセーフオブジェクト
     * @param <T> 対象オブジェクト型
     * @return 対象オブジェクトがNULLのときNULLセーフオブジェクト
     * @see ObjectUtils#defaultIfNull(Object, Object)
     */
    public static <T> T nullSafe(final T object, final T defaultValue) {
        return ObjectUtils.defaultIfNull(object, defaultValue);
    }
    /**
     * プロパティ一括コピー
     * <p>
     * オブジェクトの可視性は public でないとコピーできないことに注意すること。
     * </p>
     * @param origin コピー元オブジェクト
     * @param destination コピー先オブジェクト
     * @throws StandardRuntimeException コピーできないとき
     */
    public static void copyProperties(final Object origin, final Object destination) {
        try {
            BeanUtils.copyProperties(destination, origin);
        } catch (final IllegalAccessException e) {
            throw new StandardRuntimeException(e);
        } catch (final InvocationTargetException e) {
            throw new StandardRuntimeException(e);
        }
    }
    /**
     * プロパティ個別コピー
     * @param object コピー対象オブジェクト
     * @param name プロパティ名
     * @param value プロパティ値
     * @throws StandardRuntimeException コピーできないとき
     */
    public static void copyProperty(final Object object, final String name, final Object value) {
        try {
            BeanUtils.copyProperty(object, name, value);
        } catch (final IllegalAccessException e) {
            throw new StandardRuntimeException(e);
        } catch (final InvocationTargetException e) {
            throw new StandardRuntimeException(e);
        }
    }
    /**
     * シャローコピー
     * @param object コピー元オブジェクト
     * @return シャローコピーしたオブジェクト
     */
    public static <T extends Serializable> T shallowCopy(final T object) {
        return ObjectUtils.clone(object);
    }
    /**
     * ディープコピー
     * @param object コピー元オブジェクト
     * @return ディープコピーしたオブジェクト
     */
    public static <T extends Serializable> T deepCopy(final T object) {
        return SerializationUtils.clone(object);
    }
}
