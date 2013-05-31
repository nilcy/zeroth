// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
/**
 * 永続可能エンティティのメタモデル
 * @author nilcy
 */
// CHECKSTYLE:OFF
@StaticMetamodel(AbstractPersistable.class)
public class AbstractPersistable_ {
    /** 識別子(ID) */
    public static volatile SingularAttribute<AbstractPersistable<?>, Long> id;
}
