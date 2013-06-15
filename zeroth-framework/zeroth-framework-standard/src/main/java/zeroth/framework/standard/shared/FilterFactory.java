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
@SuppressWarnings("static-method")
public class FilterFactory {
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
    public SimpleFilter createNoticeFilter(final String keyword, final PageRequest pageRequest) {
        assert pageRequest != null;
        return new SimpleFilter(keyword, pageRequest);
    }
}
