// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.domain.parts;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import zeroth.actor.domain.Title;
import zeroth.framework.enterprise.domain.AbstractPersistable_;
/**
 * 職名権限のメタモデル
 * @author nilcy
 */
// CHECKSTYLE:OFF
@StaticMetamodel(TitleAuth.class)
public class TitleAuth_ extends AbstractPersistable_ {
    /** 職名 */
    public static volatile SingularAttribute<TitleAuth, Title> title;
    /** 権限 */
    public static volatile SingularAttribute<TitleAuth, Auth> auth;
}
