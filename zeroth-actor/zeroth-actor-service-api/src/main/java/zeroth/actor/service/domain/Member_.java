// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.domain;
import java.util.Date;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import zeroth.actor.service.domain.parts.HomeAddress;
import zeroth.actor.service.domain.parts.MemberContact;
/**
 * 社員のメタモデル
 * @author nilcy
 */
// CHECKSTYLE:OFF
@StaticMetamodel(Member.class)
public class Member_ extends Staff_ {
    /** 所属 */
    public static volatile SingularAttribute<Member, Organ> organ;
    /** アカウント */
    public static volatile SingularAttribute<Member, String> account;
    /** パスワード */
    public static volatile SingularAttribute<Member, String> password;
    /** 性別 */
    public static volatile SingularAttribute<Member, Gender> gender;
    /** 生年月日 */
    public static volatile SingularAttribute<Member, Date> birthDate;
    /** 職名 */
    public static volatile SingularAttribute<Member, Title> title;
    /** 職級 */
    public static volatile SingularAttribute<Member, Level> level;
    /** 自宅住所 */
    public static volatile SingularAttribute<Member, HomeAddress> address;
    /** 保有権限 */
    public static volatile CollectionAttribute<Member, MemberAuth> auths;
    /** 連絡先 */
    public static volatile SingularAttribute<Member, MemberContact> contact;
}
