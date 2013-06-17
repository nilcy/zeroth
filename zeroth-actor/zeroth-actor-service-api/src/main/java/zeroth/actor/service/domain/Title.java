// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.domain;
import java.util.Collection;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import zeroth.actor.service.domain.parts.TitleAuth;
import zeroth.framework.enterprise.domain.AbstractVersionable;
/**
 * 職名
 * @author nilcy
 */
@Entity
@Access(AccessType.FIELD)
@Table(name = "title", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })
@Cacheable(true)
public class Title extends AbstractVersionable<Title> {
    /** 製品番号 */
    private static final long serialVersionUID = 5468865843361146757L;
    /** 職名 */
    @Column(name = "name", nullable = false, insertable = true, updatable = true)
    private String name;
    /** 建制順 */
    @Column(name = "administrative_order", nullable = false, insertable = true, updatable = true)
    private Long order;
    /** 権限 */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "title_id", insertable = true, updatable = true)
    private Collection<TitleAuth> auths;
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
    /**
     * {@link #auths} の取得
     * @return {@link #auths}
     */
    public Collection<TitleAuth> getAuths() {
        return auths;
    }
    /**
     * {@link #auths} の設定
     * @param aAuths {@link #auths}
     */
    public void setAuths(final Collection<TitleAuth> aAuths) {
        auths = aAuths;
    }
}
