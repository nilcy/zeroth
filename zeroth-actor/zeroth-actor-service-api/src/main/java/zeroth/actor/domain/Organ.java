// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.domain;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import zeroth.framework.enterprise.domain.AbstractPersistable;
/**
 * 組織
 * @author nilcy
 */
@Entity
@Access(AccessType.FIELD)
@Table(name = "organ", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })
@Cacheable(true)
public class Organ extends AbstractPersistable<Organ> {
    /** 製品番号 */
    private static final long serialVersionUID = 4009731357822225905L;
    /** 親組織 */
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", nullable = true, insertable = true, updatable = true)
    private Organ parent;
    /** 組織名 */
    @Column(name = "name", nullable = false, insertable = true, updatable = true)
    private String name;
    /** 階層 */
    @Column(name = "level", nullable = false, insertable = true, updatable = true)
    private Long level;
    /** 建制順 */
    @Column(name = "administrative_order", nullable = false, insertable = true, updatable = true)
    private Long order;
    /**
     * {@link #parent} の取得
     * @return {@link #parent}
     */
    public Organ getParent() {
        return parent;
    }
    /**
     * {@link #parent} の設定
     * @param aParent {@link #parent}
     */
    public void setParent(final Organ aParent) {
        parent = aParent;
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
     * {@link #level} の取得
     * @return {@link #level}
     */
    public Long getLevel() {
        return level;
    }
    /**
     * {@link #level} の設定
     * @param aLevel {@link #level}
     */
    public void setLevel(final Long aLevel) {
        level = aLevel;
    }
    /**
     * {@link #order} の取得
     * @return {@link #order}
     */
    public Long getOrder() {
        return order;
    }
    /**
     * {@link #order} の設定
     * @param aOrder {@link #order}
     */
    public void setOrder(final Long aOrder) {
        order = aOrder;
    }
}
