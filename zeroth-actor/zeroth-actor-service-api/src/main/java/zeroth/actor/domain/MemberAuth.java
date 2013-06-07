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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import zeroth.actor.domain.parts.Auth;
import zeroth.framework.enterprise.domain.AbstractPersistable;
/**
 * 社員権限
 * @author nilcy
 */
@Entity
@Access(AccessType.FIELD)
@Table(name = "member_auth", uniqueConstraints = { @UniqueConstraint(columnNames = { "account",
    "auth" }) })
@Cacheable(true)
public class MemberAuth extends AbstractPersistable<MemberAuth> {
    /** 製品番号 */
    private static final long serialVersionUID = -536967469017451589L;
    /** 社員 */
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;
    /** アカウント */
    @Column(name = "account", nullable = false)
    private String account;
    /** 権限 */
    @Column(name = "auth", nullable = false)
    @Enumerated(EnumType.STRING)
    private Auth auth;
    /**
     * {@link #member} の取得
     * @return {@link #member}
     */
    public Member getMember() {
        return member;
    }
    /**
     * {@link #member} の設定
     * @param aMember {@link #member}
     */
    public void setMember(final Member aMember) {
        member = aMember;
    }
    /**
     * {@link #account} の取得
     * @return {@link #account}
     */
    public String getAccount() {
        return account;
    }
    /**
     * {@link #account} の設定
     * @param aAccount {@link #account}
     */
    public void setAccount(final String aAccount) {
        account = aAccount;
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
