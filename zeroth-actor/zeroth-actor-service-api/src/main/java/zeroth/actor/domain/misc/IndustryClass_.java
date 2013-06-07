// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.domain.misc;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import zeroth.framework.enterprise.domain.AbstractPersistable_;
/**
 * 業種のメタモデル
 * @author nilcy
 */
// CHECKSTYLE:OFF
@StaticMetamodel(IndustryClass.class)
public class IndustryClass_ extends AbstractPersistable_ {
    /** 業種コード */
    public static volatile SingularAttribute<IndustryClass, String> sector;
    /** 業種 */
    public static volatile SingularAttribute<IndustryClass, String> description;
}
