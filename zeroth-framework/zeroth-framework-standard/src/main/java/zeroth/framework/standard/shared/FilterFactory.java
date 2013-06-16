// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.shared;
/**
 * フィルタのファクトリ
 * @author nilcy
 */
public class FilterFactory {
    /** デフォルトのページ番号 */
    protected static final int DEFAULT_PAGE = 1;
    /** デフォルトのページサイズ */
    protected static final int DEFAULT_SIZE = Integer.MAX_VALUE;
    /**
     * 基本フィルタの生成
     * <dl>
     * <dt>事後条件</dt>
     * <dd>キーワードがNULL、ページ条件がデフォルトの基本フィルタを生成する。</dd>
     * </dl>
     * @return 基本フィルタ
     */
    public static SimpleFilter createSimpleFilter() {
        return new SimpleFilter(null, new PageRequest(DEFAULT_PAGE, DEFAULT_SIZE));
    }
    /**
     * 基本フィルタの生成
     * <dl>
     * <dt>事前条件</dt>
     * <dd>ページ条件は非NULLであること。</dd>
     * <dt>事後条件</dt>
     * <dd>基本フィルタは不変オブジェクトである。</dd>
     * </dl>
     * @param keyword キーワード
     * @param pageRequest ページ条件
     * @return 基本フィルタ
     */
    public static SimpleFilter createSimpleFilter(final String keyword,
        final PageRequest pageRequest) {
        if (pageRequest == null) {
            return new SimpleFilter(keyword, new PageRequest(1, DEFAULT_SIZE));
        }
        return new SimpleFilter(keyword, pageRequest);
    }
}
