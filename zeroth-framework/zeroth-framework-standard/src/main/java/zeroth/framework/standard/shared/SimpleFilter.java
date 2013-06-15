// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.shared;
/**
 * 基本フィルタ
 * @author nilcy
 */
public class SimpleFilter extends AbstractValueObject<SimpleFilter> implements WithPageRequest {
    /** 製品番号 */
    private static final long serialVersionUID = -6480223690400093077L;
    /** キーワード */
    private final String keyword;
    /** ページ条件 */
    private final PageRequest pageRequest;
    /**
     * コンストラクタ
     * @param keyword {@link #keyword}
     * @param pageRequest {@link #pageRequest}
     */
    public SimpleFilter(final String keyword, final PageRequest pageRequest) {
        this.keyword = keyword;
        this.pageRequest = pageRequest;
    }
    /**
     * {@link #keyword} の取得
     * @return {@link #keyword}
     */
    public String getKeyword() {
        return keyword;
    }
    /**
     * {@link #pageRequest} の取得
     * @return {@link #pageRequest}
     */
    @Override
    public PageRequest getPageRequest() {
        return pageRequest;
    }
}
