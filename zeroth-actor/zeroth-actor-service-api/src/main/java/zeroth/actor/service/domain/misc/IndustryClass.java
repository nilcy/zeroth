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
 * 業種
 * <p>
 * see http://www.census.gov/epcd/www/naics.html
 * </p>
 * @author nilcy
 */
@Entity
@Access(AccessType.FIELD)
@Table(name = "industry_class", uniqueConstraints = {
    @UniqueConstraint(columnNames = { "sector" }),
    @UniqueConstraint(columnNames = { "description" }) })
@Cacheable(true)
public class IndustryClass extends AbstractPersistable<IndustryClass> {
    /** 製品番号 */
    private static final long serialVersionUID = -9033077500828287823L;
    /** 業種コード */
    @Column(name = "sector", nullable = false, insertable = true, updatable = true)
    private String sector;
    /** 業種 */
    @Column(name = "description", nullable = false, insertable = true, updatable = true)
    private String description;
    /**
     * {@link #sector} の取得
     * @return {@link #sector}
     */
    public String getSector() {
        return sector;
    }
    /**
     * {@link #sector} の設定
     * @param aSector {@link #sector}
     */
    public void setSector(final String aSector) {
        sector = aSector;
    }
    /**
     * {@link #description} の取得
     * @return {@link #description}
     */
    public String getDescription() {
        return description;
    }
    /**
     * {@link #description} の設定
     * @param aDescription {@link #description}
     */
    public void setDescription(final String aDescription) {
        description = aDescription;
    }
}
