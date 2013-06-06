// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
import zeroth.framework.standard.shared.PageRequest;
/**
 * テスト参照オブジェクトのファクトリ
 * @author nilcy
 */
@SuppressWarnings("static-method")
public class TestExampleValueFactory {
    /**
     * インスタンスの作成
     * @return インスタンス
     */
    private TestExampleValue create() {
        return new TestExampleValue();
    }
    /**
     * インスタンスの作成
     * @param code コード
     * @return インスタンス
     */
    public TestExampleValue create(final String code) {
        final TestExampleValue o = create();
        o.setCode(code);
        return o;
    }
    /**
     * インスタンスの作成
     * @param code コード
     * @param pageRequest ページ条件
     * @return インスタンス
     */
    public TestExampleValue create(final String code, final PageRequest pageRequest) {
        final TestExampleValue o = create(code);
        o.setPageRequest(pageRequest);
        return o;
    }
}
