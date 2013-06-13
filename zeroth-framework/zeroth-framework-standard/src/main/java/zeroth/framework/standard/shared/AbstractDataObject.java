// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.shared;
import static org.apache.commons.lang3.builder.ToStringStyle.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
/**
 * データオブジェクト
 * <p>
 * データオブジェクトの基本的な機能を提供する。 参照オブジェクトと値オブジェクトは本クラスを継承すること。
 * </p>
 * @author nilcy
 */
public abstract class AbstractDataObject implements DataObject {
    /** 識別番号 */
    private static final long serialVersionUID = -4438164461402375117L;
    /** コンストラクタ */
    public AbstractDataObject() {
    }
    /**
     * オブジェクトの文字列表現
     * <p>
     * オブジェクトをもとに短縮形式で生成する。一時フィールド(transient)も生成キーの対象とする。
     * </p>
     * @return オブジェクトの文字列表現
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, SHORT_PREFIX_STYLE, true);
    }
    /**
     * オブジェクトの同値検査
     * <p>
     * オブジェクトと比較対象オブジェクトが等しいか検査する。一時フィールド(transient)も検査の対象とする。
     * </p>
     * @param other 比較対象オブジェクト
     * @return オブジェクトと比較対象オブジェクトが等しいとき真。等しくないとき偽。
     */
    @Override
    public boolean equals(final Object other) {
        return EqualsBuilder.reflectionEquals(this, other, true);
    }
    /**
     * オブジェクトのハッシュコード
     * <p>
     * オブジェクトをもとにハッシュコードを生成する。一時フィールド(transient)も生成キーの対象とする。
     * </p>
     */
    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, true);
    }
    /** {@inheritDoc} */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
