// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.domain.misc;
import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import zeroth.framework.enterprise.domain.AbstractPersistable_;
/**
 * 告知のメタモデル
 * @author nilcy
 */
// CHECKSTYLE:OFF
@StaticMetamodel(Notice.class)
public class Notice_ extends AbstractPersistable_ {
    /** 表題 */
    public static volatile SingularAttribute<Notice<?>, String> title;
    /** 説明 */
    public static volatile SingularAttribute<Notice<?>, String> description;
    /** 発行日 */
    public static volatile SingularAttribute<Notice<?>, Date> published;
    /** カテゴリ */
    public static volatile SingularAttribute<Notice<?>, String> category;
}
