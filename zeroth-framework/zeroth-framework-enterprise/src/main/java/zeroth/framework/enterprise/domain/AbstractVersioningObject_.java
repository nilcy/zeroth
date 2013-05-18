// ========================================================================
// Copyright (C) IMPULSE Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
/**
 * 版管理オブジェクトモデル
 * @author nilcy
 */
// CHECKSTYLE:OFF
@StaticMetamodel(AbstractVersioningObject.class)
public class AbstractVersioningObject_ extends AbstractReferenceObject_ {
    /** 版数 */
    public static volatile SingularAttribute<AbstractVersioningObject<?>, Long> version;
}
