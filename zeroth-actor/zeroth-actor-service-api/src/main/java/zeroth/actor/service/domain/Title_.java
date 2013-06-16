// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.domain;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import zeroth.actor.service.domain.parts.TitleAuth;
import zeroth.framework.enterprise.domain.AbstractPersistable_;
/**
 * 職名のメタモデル
 * @author nilcy
 */
// CHECKSTYLE:OFF
@StaticMetamodel(Title.class)
public class Title_ extends AbstractPersistable_ {
    /** 職名 */
    public static volatile SingularAttribute<Title, String> name;
    /** 建制順 */
    public static volatile SingularAttribute<Title, Long> order;
    /** 権限 */
    public static volatile CollectionAttribute<Title, TitleAuth> auths;
}
