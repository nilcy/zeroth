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
// @SuppressWarnings("all")
public class TestExample extends AbstractRevisedObject<TestExample> {
    /** 識別番号 */
    private static final long serialVersionUID = 5105345042376016853L;
    /** コード */
    @Column(name = "code", nullable = false)
    private String code;
    /** コンストラクタ */
    public TestExample() {
    }
    /**
     * コンストラクタ
     * @param aCode {@link #code}
     */
    public TestExample(final String aCode) {
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
