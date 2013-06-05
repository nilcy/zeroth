// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
/**
 * テスト参照オブジェクトのファクトリ
 * @author nilcy
 */
@SuppressWarnings("static-method")
public class TestExampleFactory {
    /** コンストラクタ */
    public TestExampleFactory() {
    }
    /**
     * インスタンスの作成
     * @return インスタンス
     */
    public TestExample create() {
        return new TestExample();
    }
    /**
     * インスタンスの作成
     * @param code コード
     * @return インスタンス
     */
    public TestExample create(final String code) {
        final TestExample o = create();
        o.setCode(code);
        return o;
    }
}
