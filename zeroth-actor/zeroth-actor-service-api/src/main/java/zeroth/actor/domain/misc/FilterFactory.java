// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.domain.misc;
import java.util.Date;
import zeroth.framework.standard.shared.PageRequest;
/**
 * フィルタのファクトリ
 * @author nilcy
 */
@SuppressWarnings("static-method")
public class FilterFactory {
    /**
     * 告知フィルタの生成
     * <dl>
     * <dt>事前条件</dt>
     * <dd>ページ条件は非NULLであること。</dd>
     * <dt>事後条件</dt>
     * <dd>告知フィルタは不変オブジェクトである。</dd>
     * </dl>
     * @param title 表題
     * @param description 説明
     * @param published 発行日
     * @param category カテゴリ
     * @param pageRequest ページ条件
     * @return 告知フィルタ
     */
    public NoticeFilter createNoticeFilter(final String title, final String description,
        final Date published, final String category, final PageRequest pageRequest) {
        assert pageRequest != null;
        return new NoticeFilter(title, description, published, category, pageRequest);
    }
}
