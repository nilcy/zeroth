// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.shared;
import org.apache.commons.lang3.builder.EqualsBuilder;
/**
 * 値オブジェクト
 * @param <T> 値オブジェクト型
 * @author nilcy
 */
public abstract class AbstractValueObject<T extends AbstractValueObject<T>> extends
    AbstractDataObject implements ValueObject<T> {
    /** 識別番号 */
    private static final long serialVersionUID = 437387339515812017L;
    /** コンストラクタ */
    public AbstractValueObject() {
    }
    /**
     * {@inheritDoc}
     * <p>
     * すべての属性値について同一性を自動的に確認する。ただし、一時項目(transient)は比較対象から除外とする。
     * </p>
     */
    @Override
    public boolean sameValueAs(final T other) {
        return EqualsBuilder.reflectionEquals(this, other, false);
    }
}
