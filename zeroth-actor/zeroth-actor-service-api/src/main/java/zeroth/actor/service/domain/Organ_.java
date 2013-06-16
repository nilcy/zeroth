// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.domain;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import zeroth.framework.enterprise.domain.AbstractPersistable_;
/**
 * 組織のメタモデル
 * @author nilcy
 */
// CHECKSTYLE:OFF
@StaticMetamodel(Organ.class)
public class Organ_ extends AbstractPersistable_ {
    /** 親組織 */
    public static volatile SingularAttribute<Organ, Organ> parent;
    /** 組織名 */
    public static volatile SingularAttribute<Organ, String> name;
    /** 階層 */
    public static volatile SingularAttribute<Organ, Long> level;
    /** 建制順 */
    public static volatile SingularAttribute<Organ, Long> order;
}
