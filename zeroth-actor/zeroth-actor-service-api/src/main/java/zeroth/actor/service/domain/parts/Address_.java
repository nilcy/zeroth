// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.domain.parts;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import zeroth.framework.enterprise.domain.AbstractPersistable_;
/**
 * 住所のメタモデル
 * @author nilcy
 */
// CHECKSTYLE:OFF
@StaticMetamodel(Address.class)
public class Address_ extends AbstractPersistable_ {
    /** 住所宛名 */
    public static volatile SingularAttribute<Address<?>, String> name;
    /** 郵便番号 */
    public static volatile SingularAttribute<Address<?>, Long> code;
    /** 都道府県 */
    public static volatile SingularAttribute<Address<?>, String> pref;
    /** 市区町村 */
    public static volatile SingularAttribute<Address<?>, String> city;
    /** 町域 */
    public static volatile SingularAttribute<Address<?>, String> town;
    /** 丁目番地 */
    public static volatile SingularAttribute<Address<?>, String> street;
}
