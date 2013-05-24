// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
import javax.persistence.Entity;
import javax.persistence.Table;
/**
 * テスト改訂オブジェクト
 * @author nilcy
 */
@Entity
@Table(name = "Test_Revised_Object")
// @SuppressWarnings("all")
public class TestRevised extends AbstractRevisedObject<TestRevised> {
    /** 識別番号 */
    private static final long serialVersionUID = 3834376793666440948L;
}
