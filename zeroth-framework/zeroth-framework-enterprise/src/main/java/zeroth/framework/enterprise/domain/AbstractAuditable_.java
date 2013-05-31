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
 * 監査可能エンティティのメタモデル
 * @author nilcy
 */
// CHECKSTYLE:OFF
@StaticMetamodel(AbstractAuditable.class)
public class AbstractAuditable_ extends AbstractPersistable_ {
    /** 作成者(ID) */
    public static volatile SingularAttribute<AbstractAuditable<?>, Long> createdBy;
    /** 登録日時 */
    public static volatile SingularAttribute<AbstractAuditable<?>, Date> createdDate;
    /** 更新者(ID) */
    public static volatile SingularAttribute<AbstractAuditable<?>, Long> lastModifiedBy;
    /** 更新日時 */
    public static volatile SingularAttribute<AbstractAuditable<?>, Date> lastModifiedDate;
}
