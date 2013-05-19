// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
/**
 * テスト用のサンプルオブジェクトモデル
 * @author nilcy
 */
// CHECKSTYLE:OFF
@StaticMetamodel(TestExampleObject.class)
public class TestExampleObject_ extends AbstractRevisedObject_ {
    /** コード */
    public static volatile SingularAttribute<TestExampleObject, String> code;
}
