// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.domain.misc;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import zeroth.framework.enterprise.domain.AbstractPersistable_;
/**
 * 上場先のメタモデル
 * @author nilcy
 */
// CHECKSTYLE:OFF
@StaticMetamodel(ListedSection.class)
public class ListedSection_ extends AbstractPersistable_ {
    /** 上場先 */
    public static volatile SingularAttribute<ListedSection, String> section;
}
