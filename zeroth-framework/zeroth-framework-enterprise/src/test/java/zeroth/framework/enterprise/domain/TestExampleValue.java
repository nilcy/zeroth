// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
import zeroth.framework.standard.shared.PageRequest;
/**
 * テスト値オブジェクト
 * @author nilcy
 */
public class TestExampleValue extends AbstractValueObject<TestExampleValue> {
    /** 製品番号 */
    private static final long serialVersionUID = -5878383282091462127L;
    /** コード */
    private String code;
    /** ページ条件 */
    private PageRequest pageRequest;
    /** コンストラクタ */
    public TestExampleValue() {
    }
    /**
     * コンストラクタ
     * @param code コード
     */
    public TestExampleValue(final String code) {
        this.code = code;
    }
    /**
     * {@link #code} の取得
     * @return {@link #code}
     */
    public String getCode() {
        return code;
    }
    /**
     * {@link #code} の設定
     * @param code {@link #code}
     */
    public void setCode(final String code) {
        this.code = code;
    }
    /**
     * {@link #pageRequest} の取得
     * @return {@link #pageRequest}
     */
    public PageRequest getPageRequest() {
        return pageRequest;
    }
    /**
     * {@link #pageRequest} の設定
     * @param pageRequest {@link #pageRequest}
     */
    public void setPageRequest(final PageRequest pageRequest) {
        this.pageRequest = pageRequest;
    }
}
