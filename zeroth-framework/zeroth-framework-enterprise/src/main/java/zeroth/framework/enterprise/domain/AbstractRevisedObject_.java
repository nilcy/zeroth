// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
/**
 * 改訂オブジェクトモデル
 * @author nilcy
 */
// CHECKSTYLE:OFF
@StaticMetamodel(AbstractRevisedObject.class)
public class AbstractRevisedObject_ extends AbstractVersionedObject_ {
    /** 登録日時 */
    public static volatile SingularAttribute<AbstractRevisedObject<?>, Date> created;
    /** 更新日時 */
    public static volatile SingularAttribute<AbstractRevisedObject<?>, Date> updated;
}
