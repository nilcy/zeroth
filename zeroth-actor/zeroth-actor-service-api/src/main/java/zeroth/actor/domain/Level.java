// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.domain;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import zeroth.framework.enterprise.domain.AbstractPersistable;
/**
 * 職級
 * @author nilcy
 */
@Entity
@Access(AccessType.FIELD)
@Table(name = "level", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })
@Cacheable(true)
public class Level extends AbstractPersistable<Level> {
    /** 製品番号 */
    private static final long serialVersionUID = -5371798431488961210L;
    /** 職級 */
    @Column(name = "name", nullable = false, insertable = true, updatable = true)
    private String name;
    /** 職級順 */
    @Column(name = "rank", nullable = false, insertable = true, updatable = true)
    private Long rank;
    /** コンストラクタ */
    public Level() {
        super();
    }
    /**
     * {@link #name} の取得
     * @return {@link #name}
     */
    public String getName() {
        return name;
    }
    /**
     * {@link #name} の設定
     * @param aName {@link #name}
     */
    public void setName(final String aName) {
        name = aName;
    }
    /**
     * {@link #rank} の取得
     * @return {@link #rank}
     */
    public Long getRank() {
        return rank;
    }
    /**
     * {@link #rank} の設定
     * @param aRank {@link #rank}
     */
    public void setRank(final Long aRank) {
        rank = aRank;
    }
}
