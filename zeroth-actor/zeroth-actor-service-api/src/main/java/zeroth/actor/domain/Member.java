// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.domain;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import zeroth.actor.domain.parts.HomeAddress;
import zeroth.actor.domain.parts.MemberContact;
/**
 * 社員
 * @author nilcy
 */
@Entity
@Table(name = "member", uniqueConstraints = { @UniqueConstraint(columnNames = { "account" }) })
@DiscriminatorValue("M")
@Cacheable(true)
public class Member extends Staff<Member> {
    /** 製品番号 */
    private static final long serialVersionUID = -1895555132482469284L;
    /** 所属 */
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "organ_id", nullable = true, insertable = true, updatable = true)
    private Organ organ;
    /** アカウント */
    @Column(name = "account", nullable = false, insertable = true, updatable = true)
    private String account;
    /** パスワード */
    @Column(name = "password", nullable = false, insertable = true, updatable = true)
    private String password;
    /** 性別 */
    @Column(name = "gender", nullable = true, insertable = true, updatable = true)
    @Enumerated(EnumType.STRING)
    private Gender gender;
    /** 生年月日 */
    @Column(name = "birth_date", nullable = true, insertable = true, updatable = true)
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    /** 職名 */
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "title_id", nullable = true, insertable = true, updatable = true)
    private Title title;
    /** 職級 */
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "level_id", nullable = true, insertable = true, updatable = true)
    private Level level;
    /** 自宅住所 */
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", nullable = false, insertable = true, updatable = true)
    private HomeAddress address;
    /** 保有権限 */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "id", nullable = true, insertable = true, updatable = true)
    private Collection<MemberAuth> auths;
    /** 連絡先 */
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id", nullable = false, insertable = true, updatable = true)
    private MemberContact contact;
    /**
     * {@link #organ} の取得
     * @return {@link #organ}
     */
    public Organ getOrgan() {
        return organ;
    }
    /**
     * {@link #organ} の設定
     * @param aOrgan {@link #organ}
     */
    public void setOrgan(final Organ aOrgan) {
        organ = aOrgan;
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
     * {@link #password} の取得
     * @return {@link #password}
     */
    public String getPassword() {
        return password;
    }
    /**
     * {@link #password} の設定
     * @param aPassword {@link #password}
     */
    public void setPassword(final String aPassword) {
        password = aPassword;
    }
    /**
     * {@link #gender} の取得
     * @return {@link #gender}
     */
    public Gender getGender() {
        return gender;
    }
    /**
     * {@link #gender} の設定
     * @param aGender {@link #gender}
     */
    public void setGender(final Gender aGender) {
        gender = aGender;
    }
    /**
     * {@link #birthDate} の取得
     * @return {@link #birthDate}
     */
    public Date getBirthDate() {
        return birthDate;
    }
    /**
     * {@link #birthDate} の設定
     * @param aBirthDate {@link #birthDate}
     */
    public void setBirthDate(final Date aBirthDate) {
        birthDate = aBirthDate;
    }
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
     * {@link #level} の取得
     * @return {@link #level}
     */
    public Level getLevel() {
        return level;
    }
    /**
     * {@link #level} の設定
     * @param aLevel {@link #level}
     */
    public void setLevel(final Level aLevel) {
        level = aLevel;
    }
    /**
     * {@link #address} の取得
     * @return {@link #address}
     */
    public HomeAddress getAddress() {
        return address;
    }
    /**
     * {@link #address} の設定
     * @param aAddress {@link #address}
     */
    public void setAddress(final HomeAddress aAddress) {
        address = aAddress;
    }
    /**
     * {@link #auths} の取得
     * @return {@link #auths}
     */
    public Collection<MemberAuth> getAuths() {
        return auths;
    }
    /**
     * {@link #auths} の設定
     * @param aAuths {@link #auths}
     */
    public void setAuths(final Collection<MemberAuth> aAuths) {
        auths = aAuths;
    }
    /**
     * {@link #contact} の取得
     * @return {@link #contact}
     */
    public MemberContact getContact() {
        return contact;
    }
    /**
     * {@link #contact} の設定
     * @param aContact {@link #contact}
     */
    public void setContact(final MemberContact aContact) {
        contact = aContact;
    }
}
