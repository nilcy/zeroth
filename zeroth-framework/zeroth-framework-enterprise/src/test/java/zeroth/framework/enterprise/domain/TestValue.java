// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
/**
 * テスト情報(値オブジェクト)
 * @author nilcy
 */
// @SuppressWarnings("all")
public class TestValue extends AbstractValueObject<TestValue> {
    /** 識別番号 */
    private static final long serialVersionUID = 3946455630058824491L;
    /** FOO */
    private String foo;
    /**
     * {@link #foo} の取得
     * @return {@link #foo}
     */
    public String getFoo() {
        return foo;
    }
    /**
     * {@link #foo} の設定
     * @param foo {@link #foo}
     */
    public void setFoo(final String foo) {
        this.foo = foo;
    }
}
