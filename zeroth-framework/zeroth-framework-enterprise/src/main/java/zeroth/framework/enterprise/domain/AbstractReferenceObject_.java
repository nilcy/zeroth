// ========================================================================
// Copyright (C) IMPULSE Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
/**
 * 参照オブジェクトモデル
 * @author nilcy
 */
// CHECKSTYLE:OFF
@StaticMetamodel(AbstractReferenceObject.class)
public class AbstractReferenceObject_ {
    /** ID */
    public static volatile SingularAttribute<AbstractReferenceObject<?>, Long> id;
}
