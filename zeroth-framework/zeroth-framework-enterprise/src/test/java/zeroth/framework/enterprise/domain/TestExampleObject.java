// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
/**
 * テスト用のサンプルオブジェクト
 * @author nilcy
 */
@Entity
@Table(name = "Test_Example_Object")
@SuppressWarnings("all")
public class TestExampleObject extends AbstractRevisedObject<TestExampleObject> {
    /** コード */
    @Column(name = "code", nullable = false)
    private String code;
    /** コンストラクタ */
    private TestExampleObject() {
    }
    /**
     * コンストラクタ
     * @param aCode {@link #code}
     */
    public TestExampleObject(final String aCode) {
        this.code = aCode;
    }
    /**
     * {@link #code} の取得
     * @return {@link #code}
     */
    public String getCode() {
        return this.code;
    }
    /**
     * {@link #code} の設定
     * @param aCode {@link #code}
     */
    public void setCode(final String aCode) {
        this.code = aCode;
    }
}
