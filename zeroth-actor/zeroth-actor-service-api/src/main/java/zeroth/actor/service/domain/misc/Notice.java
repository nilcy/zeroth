// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.domain.misc;
import java.util.Date;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import zeroth.framework.enterprise.domain.AbstractPersistable;
/**
 * 告知
 * @param <T> 告知オブジェクト型
 * @author nilcy
 */
@Entity
@Table(name = "notice")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "notice_type", discriminatorType = DiscriminatorType.STRING)
@Cacheable(true)
public class Notice<T extends Notice<T>> extends AbstractPersistable<T> {
    /** 製品番号 */
    private static final long serialVersionUID = 1479222182416558368L;
    /** 表題 */
    @Column(name = "title", nullable = false, insertable = true, updatable = true)
    private String title;
    /** 説明 */
    @Column(name = "description", nullable = false, insertable = true, updatable = true)
    private String description;
    /** 発行日 */
    @Column(name = "published", nullable = false, insertable = true, updatable = true)
    @Temporal(TemporalType.DATE)
    private Date published;
    /** カテゴリ */
    @Column(name = "category", nullable = true, insertable = true, updatable = true)
    private String category;
    /**
     * {@link #title} の取得
     * @return {@link #title}
     */
    public String getTitle() {
        return this.title;
    }
    /**
     * {@link #title} の設定
     * @param aTitle {@link #title}
     */
    public void setTitle(final String aTitle) {
        this.title = aTitle;
    }
    /**
     * {@link #description} の取得
     * @return {@link #description}
     */
    public String getDescription() {
        return this.description;
    }
    /**
     * {@link #description} の設定
     * @param aDescription {@link #description}
     */
    public void setDescription(final String aDescription) {
        this.description = aDescription;
    }
    /**
     * {@link #published} の取得
     * @return {@link #published}
     */
    public Date getPublished() {
        return this.published;
    }
    /**
     * {@link #published} の設定
     * @param aPublished {@link #published}
     */
    public void setPublished(final Date aPublished) {
        this.published = aPublished;
    }
    /**
     * {@link #category} の取得
     * @return {@link #category}
     */
    public String getCategory() {
        return this.category;
    }
    /**
     * {@link #category} の設定
     * @param aCategory {@link #category}
     */
    public void setCategory(final String aCategory) {
        this.category = aCategory;
    }
}
