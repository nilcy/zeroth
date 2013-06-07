// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.domain.parts;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import zeroth.framework.enterprise.domain.AbstractPersistable_;
/**
 * 連絡先のメタモデル
 * @author nilcy
 */
// CHECKSTYLE:OFF
@StaticMetamodel(Contact.class)
public class Contact_ extends AbstractPersistable_ {
    /** 連絡先宛名 */
    public static volatile SingularAttribute<Contact<?>, String> name;
    /** 電話番号 */
    public static volatile SingularAttribute<Contact<?>, String> telno;
    /** 携帯番号 */
    public static volatile SingularAttribute<Contact<?>, String> cellno;
    /** FAX番号 */
    public static volatile SingularAttribute<Contact<?>, String> faxno;
    /** メールアドレス */
    public static volatile SingularAttribute<Contact<?>, String> email;
}
