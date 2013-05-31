// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.shared;
/**
 * テスト用データオブジェクト
 * @author nilcy
 */
public class TestDataObject extends AbstractDataObject {
    /** 識別番号 */
    private static final long serialVersionUID = -6959622318388079127L;
    /** FOO */
    private String foo;
    /** BAR */
    private transient String bar;
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
    /**
     * {@link #bar} の取得
     * @return {@link #bar}
     */
    public String getBar() {
        return this.bar;
    }
    /**
     * {@link #bar} の設定
     * @param aBar {@link #bar}
     */
    public void setBar(final String aBar) {
        this.bar = aBar;
    }
}
