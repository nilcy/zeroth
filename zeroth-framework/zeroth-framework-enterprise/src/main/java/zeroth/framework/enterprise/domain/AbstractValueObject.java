// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
import zeroth.framework.standard.shared.AbstractDataObject;
/**
 * 値オブジェクト
 * @param <T> 値オブジェクト型
 * @author nilcy
 */
public abstract class AbstractValueObject<T extends AbstractValueObject<T>> extends
    AbstractDataObject<T> implements ValueObject<T> {
    /** 識別番号 */
    private static final long serialVersionUID = 437387339515812017L;
    /** コンストラクタ */
    public AbstractValueObject() {
    }
}
