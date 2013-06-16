// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.domain.misc;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import zeroth.framework.enterprise.domain.AbstractPersistable;
/**
 * 上場先
 * @author nilcy
 */
@Entity
@Access(AccessType.FIELD)
@Table(name = "listed_section", uniqueConstraints = { @UniqueConstraint(columnNames = { "section" }) })
@Cacheable(true)
public class ListedSection extends AbstractPersistable<ListedSection> {
    /** 製品番号 */
    private static final long serialVersionUID = 4211135076507326572L;
    /** 上場先 */
    @Column(name = "section", nullable = false, insertable = true, updatable = true)
    private String section;
    /**
     * {@link #section} の取得
     * @return {@link #section}
     */
    public String getSection() {
        return section;
    }
    /**
     * {@link #section} の設定
     * @param aSection {@link #section}
     */
    public void setSection(final String aSection) {
        section = aSection;
    }
}
