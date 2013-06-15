// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.domain.misc;
import java.util.Date;
import zeroth.framework.standard.shared.AbstractValueObject;
import zeroth.framework.standard.shared.CommonUtils;
import zeroth.framework.standard.shared.PageRequest;
import zeroth.framework.standard.shared.WithPageRequest;
/**
 * 告知フィルタ
 * @author nilcy
 */
public class NoticeFilter extends AbstractValueObject<NoticeFilter> implements WithPageRequest {
    /** 製品番号 */
    private static final long serialVersionUID = 106469438156145920L;
    /** 表題 */
    private final String title;
    /** 説明 */
    private final String description;
    /** 発行日 */
    private final Date published;
    /** カテゴリ */
    private final String category;
    /** ページ条件 */
    private final PageRequest pageRequest;
    /**
     * コンストラクタ
     * @param title {@link #title}
     * @param description {@link #description}
     * @param published {@link #published}
     * @param category {@link #category}
     * @param pageRequest {@link #pageRequest}
     */
    public NoticeFilter(final String title, final String description, final Date published,
        final String category, final PageRequest pageRequest) {
        this.title = title;
        this.description = description;
        this.published = published;
        this.category = category;
        this.pageRequest = pageRequest;
    }
    /**
     * {@link #title} の取得
     * @return {@link #title}
     */
    public String getTitle() {
        return title;
    }
    /**
     * {@link #description} の取得
     * @return {@link #description}
     */
    public String getDescription() {
        return description;
    }
    /**
     * {@link #published} の取得
     * @return {@link #published}
     */
    public Date getPublished() {
        return CommonUtils.shallowCopy(published);
    }
    /**
     * {@link #category} の取得
     * @return {@link #category}
     */
    public String getCategory() {
        return category;
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
