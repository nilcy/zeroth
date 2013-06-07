// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.domain.parts;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import zeroth.actor.domain.Title;
import zeroth.framework.enterprise.domain.AbstractPersistable;
/**
 * 職名権限
 * @author nilcy
 */
@Entity
@Access(AccessType.FIELD)
@Table(name = "title_auth", uniqueConstraints = { @UniqueConstraint(columnNames = { "title_id",
    "auth" }) })
@Cacheable(true)
public class TitleAuth extends AbstractPersistable<TitleAuth> {
    /** 製品番号 */
    private static final long serialVersionUID = -5449913362069090600L;
    /** 職名 */
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "title_id", nullable = false, insertable = true, updatable = true)
    private Title title;
    /** 権限 */
    @Column(name = "auth", nullable = false, insertable = true, updatable = true)
    @Enumerated(EnumType.STRING)
    private Auth auth;
    /**
     * {@link #title} の取得
     * @return {@link #title}
     */
    public Title getTitle() {
        return title;
    }
    /**
     * {@link #title} の設定
     * @param aTitle {@link #title}
     */
    public void setTitle(final Title aTitle) {
        title = aTitle;
    }
    /**
     * {@link #auth} の取得
     * @return {@link #auth}
     */
    public Auth getAuth() {
        return auth;
    }
    /**
     * {@link #auth} の設定
     * @param aAuth {@link #auth}
     */
    public void setAuth(final Auth aAuth) {
        auth = aAuth;
    }
}
