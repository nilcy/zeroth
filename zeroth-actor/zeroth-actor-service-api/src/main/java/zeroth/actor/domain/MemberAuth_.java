// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.domain;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import zeroth.actor.domain.parts.Auth;
import zeroth.framework.enterprise.domain.AbstractPersistable_;
/**
 * 社員権限のメタモデル
 * @author nilcy
 */
// CHECKSTYLE:OFF
@StaticMetamodel(MemberAuth.class)
public class MemberAuth_ extends AbstractPersistable_ {
    /** 社員 */
    public static volatile SingularAttribute<MemberAuth, Member> member;
    /** アカウント */
    public static volatile SingularAttribute<MemberAuth, String> account;
    /** 権限 */
    public static volatile SingularAttribute<MemberAuth, Auth> auth;
}
