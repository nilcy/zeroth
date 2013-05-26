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
     * @param aObject チェック対象オブジェクト
     * @return 非NULLオブジェクト
     * @throws NullPointerException チェック対象オブジェクトがNULLのとき
     */
    public static <T> T notNull(final T aObject) {
        return Validate.notNull(aObject);
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
    /**
     * プロパティ一括コピー
     * <p>
     * オブジェクトの可視性は public でないとコピーできないことに注意すること。
     * </p>
     * @param aOrig コピー元オブジェクト
     * @param aDest コピー先オブジェクト
     * @throws StandardRuntimeException コピーできないとき
     */
    public static void copyProperties(final Object aOrig, final Object aDest) {
        try {
            BeanUtils.copyProperties(aDest, aOrig);
        } catch (final IllegalAccessException e) {
            throw new StandardRuntimeException(e);
        } catch (final InvocationTargetException e) {
            throw new StandardRuntimeException(e);
        }
    }
    /**
     * プロパティ個別コピー
     * @param aObject コピー対象オブジェクト
     * @param aName プロパティ名
     * @param aValue プロパティ値
     * @throws StandardRuntimeException コピーできないとき
     */
    public static void copyProperty(final Object aObject, final String aName, final Object aValue) {
        try {
            BeanUtils.copyProperty(aObject, aName, aValue);
        } catch (final IllegalAccessException e) {
            throw new StandardRuntimeException(e);
        } catch (final InvocationTargetException e) {
            throw new StandardRuntimeException(e);
        }
    }
    /**
     * シャローコピー
     * @param aObject コピー元オブジェクト
     * @return シャローコピーしたオブジェクト
     */
    public static <T extends Serializable> T shallowCopy(final T aObject) {
        return ObjectUtils.clone(aObject);
    }
    /**
     * ディープコピー
     * @param aObject コピー元オブジェクト
     * @return ディープコピーしたオブジェクト
     */
    public static <T extends Serializable> T deepCopy(final T aObject) {
        return SerializationUtils.clone(aObject);
    }
}
