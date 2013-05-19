// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
/**
 * テスト用の参照オブジェクト
 * @author nilcy
 */
@SuppressWarnings("all")
public class TestValueObject extends AbstractValueObject<TestValueObject> {
    private String foo;
    /**
     * {@link #foo} の取得
     * @return {@link #foo}
     */
    public String getFoo() {
        return this.foo;
    }
    /**
     * {@link #foo} の設定
     * @param aFoo {@link #foo}
     */
    public void setFoo(final String aFoo) {
        this.foo = aFoo;
    }
}
