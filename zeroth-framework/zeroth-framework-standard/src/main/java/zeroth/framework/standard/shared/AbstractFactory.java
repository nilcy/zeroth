// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.shared;
import java.lang.reflect.ParameterizedType;
/**
 * データオブジェクトのファクトリ
 * <p>
 * データオブジェクトのファクトリ基本クラス。データオブジェクト固有のファクトリは本クラスを継承することで標準コンストラクタの呼出しが共通化される。
 * </p>
 * @param <T> データオブジェクト型
 * @author nilcy
 */
public abstract class AbstractFactory<T extends DataObject> {
    /** コンストラクタ */
    protected AbstractFactory() {
    }
    /**
     * インスタンスの作成
     * @return インスタンス
     */
    @SuppressWarnings("unchecked")
    public T create() {
        try {
            return ((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0]).newInstance();
        } catch (final InstantiationException e) {
            throw new StandardRuntimeException(e);
        } catch (final IllegalAccessException e) {
            throw new StandardRuntimeException(e);
        }
    }
}
