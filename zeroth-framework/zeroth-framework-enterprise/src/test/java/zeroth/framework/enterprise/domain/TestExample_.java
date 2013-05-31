// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
/**
 * テストオブジェクトのメタモデル
 * @author nilcy
 */
// CHECKSTYLE:OFF
@StaticMetamodel(TestExample.class)
@SuppressWarnings("all")
public class TestExample_ extends AbstractAuditable_ {
    public static volatile SingularAttribute<TestExample, String> code;
}
