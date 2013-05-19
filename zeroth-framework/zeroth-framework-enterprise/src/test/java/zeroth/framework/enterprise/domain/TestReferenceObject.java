// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
import javax.persistence.Entity;
import javax.persistence.Table;
/**
 * テスト用の参照オブジェクト
 * @author nilcy
 */
@Entity
@Table(name = "TEST_REFERENCE_OBJECT")
// @SuppressWarnings("all")
public class TestReferenceObject extends AbstractReferenceObject<TestReferenceObject> {
    /** 識別番号 */
    private static final long serialVersionUID = 3620864252783910657L;
    /** コンストラクタ */
    public TestReferenceObject() {
    }
}
