// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.domain;
import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import zeroth.actor.domain.misc.IndustryClass;
import zeroth.actor.domain.misc.ListedSection;
import zeroth.actor.domain.parts.OfficeAddress;
import zeroth.framework.enterprise.domain.AbstractPersistable_;
/**
 * 取引先のメタモデル
 * @author nilcy
 */
// CHECKSTYLE:OFF
@StaticMetamodel(Company.class)
public class Company_ extends AbstractPersistable_ {
    /** 正式名 */
    public static volatile SingularAttribute<Company<?>, String> officialName;
    /** カナ名 */
    public static volatile SingularAttribute<Company<?>, String> aliasName;
    /** 英文名 */
    public static volatile SingularAttribute<Company<?>, String> englishName;
    /** 略式名 */
    public static volatile SingularAttribute<Company<?>, String> summaryName;
    /** 住所 */
    public static volatile SingularAttribute<Company<?>, OfficeAddress> address;
    /** 電話番号 */
    public static volatile SingularAttribute<Company<?>, String> telno;
    /** 設立日 */
    public static volatile SingularAttribute<Company<?>, Date> established;
    /** 業種 */
    public static volatile SingularAttribute<Company<?>, IndustryClass> industryClass;
    /** 代表者 */
    public static volatile SingularAttribute<Company<?>, String> representative;
    /** 資本金 */
    public static volatile SingularAttribute<Company<?>, Long> capital;
    /** 決算月 */
    public static volatile SingularAttribute<Company<?>, Long> accountingPeriod;
    /** 上場先 */
    public static volatile SingularAttribute<Company<?>, ListedSection> listedSection;
}
