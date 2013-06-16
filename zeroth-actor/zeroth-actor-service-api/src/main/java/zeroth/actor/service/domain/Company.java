// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.domain;
import java.util.Date;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import zeroth.actor.service.domain.misc.IndustryClass;
import zeroth.actor.service.domain.misc.ListedSection;
import zeroth.actor.service.domain.parts.OfficeAddress;
import zeroth.framework.enterprise.domain.AbstractPersistable;
/**
 * 取引先
 * @param <T> 取引先オブジェクト型
 * @author nilcy
 */
@Entity
@Table(name = "company", uniqueConstraints = {
    @UniqueConstraint(columnNames = { "official_name" }),
    @UniqueConstraint(columnNames = { "alias_name" }) })
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "company_type", discriminatorType = DiscriminatorType.STRING)
@Cacheable(true)
public class Company<T extends Company<T>> extends AbstractPersistable<T> {
    /** 製品番号 */
    private static final long serialVersionUID = 4188961406940447335L;
    /** 正式名 */
    @Column(name = "official_name", nullable = false, insertable = true, updatable = true)
    private String officialName;
    /** カナ名 */
    @Column(name = "alias_name", nullable = false, insertable = true, updatable = true)
    private String aliasName;
    /** 英文名 */
    @Column(name = "english_name", nullable = true, insertable = true, updatable = true)
    private String englishName;
    /** 略式名 */
    @Column(name = "summary_name", nullable = true, insertable = true, updatable = true)
    private String summaryName;
    /** 住所 */
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", nullable = false, insertable = true, updatable = true)
    private OfficeAddress address;
    /** 電話番号 */
    @Column(name = "telno", nullable = true, insertable = true, updatable = true)
    private String telno;
    /** 設立日 */
    @Column(name = "established", nullable = true, insertable = true, updatable = true)
    @Temporal(TemporalType.DATE)
    private Date established;
    /** 業種 */
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "industry_class_id", nullable = true, insertable = true, updatable = true)
    private IndustryClass industryClass;
    /** 代表者 */
    @Column(name = "representative", nullable = true, insertable = true, updatable = true)
    private String representative;
    /** 資本金 */
    @Column(name = "capital", nullable = true, insertable = true, updatable = true)
    private Long capital;
    /** 決算月 */
    @Column(name = "accounting_period", nullable = true, insertable = true, updatable = true)
    private Long accountingPeriod;
    /** 上場先 */
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "listed_section_id", nullable = true, insertable = true, updatable = true)
    private ListedSection listedSection;
    /** コンストラクタ */
    public Company() {
    }
    /**
     * {@link #officialName} の取得
     * @return {@link #officialName}
     */
    public String getOfficialName() {
        return this.officialName;
    }
    /**
     * {@link #officialName} の設定
     * @param aOfficialName {@link #officialName}
     */
    public void setOfficialName(final String aOfficialName) {
        this.officialName = aOfficialName;
    }
    /**
     * {@link #aliasName} の取得
     * @return {@link #aliasName}
     */
    public String getAliasName() {
        return this.aliasName;
    }
    /**
     * {@link #aliasName} の設定
     * @param aAliasName {@link #aliasName}
     */
    public void setAliasName(final String aAliasName) {
        this.aliasName = aAliasName;
    }
    /**
     * {@link #englishName} の取得
     * @return {@link #englishName}
     */
    public String getEnglishName() {
        return this.englishName;
    }
    /**
     * {@link #englishName} の設定
     * @param aEnglishName {@link #englishName}
     */
    public void setEnglishName(final String aEnglishName) {
        this.englishName = aEnglishName;
    }
    /**
     * {@link #summaryName} の取得
     * @return {@link #summaryName}
     */
    public String getSummaryName() {
        return this.summaryName;
    }
    /**
     * {@link #summaryName} の設定
     * @param aSummaryName {@link #summaryName}
     */
    public void setSummaryName(final String aSummaryName) {
        this.summaryName = aSummaryName;
    }
    /**
     * {@link #address} の取得
     * @return {@link #address}
     */
    public OfficeAddress getAddress() {
        return this.address;
    }
    /**
     * {@link #address} の設定
     * @param aAddress {@link #address}
     */
    public void setAddress(final OfficeAddress aAddress) {
        this.address = aAddress;
    }
    /**
     * {@link #telno} の取得
     * @return {@link #telno}
     */
    public String getTelno() {
        return this.telno;
    }
    /**
     * {@link #telno} の設定
     * @param aTelno {@link #telno}
     */
    public void setTelno(final String aTelno) {
        this.telno = aTelno;
    }
    /**
     * {@link #established} の取得
     * @return {@link #established}
     */
    public Date getEstablished() {
        return this.established;
    }
    /**
     * {@link #established} の設定
     * @param aEstablished {@link #established}
     */
    public void setEstablished(final Date aEstablished) {
        this.established = aEstablished;
    }
    /**
     * {@link #industryClass} の取得
     * @return {@link #industryClass}
     */
    public IndustryClass getIndustryClass() {
        return this.industryClass;
    }
    /**
     * {@link #industryClass} の設定
     * @param aIndustryClass {@link #industryClass}
     */
    public void setIndustryClass(final IndustryClass aIndustryClass) {
        this.industryClass = aIndustryClass;
    }
    /**
     * {@link #representative} の取得
     * @return {@link #representative}
     */
    public String getRepresentative() {
        return this.representative;
    }
    /**
     * {@link #representative} の設定
     * @param aRepresentative {@link #representative}
     */
    public void setRepresentative(final String aRepresentative) {
        this.representative = aRepresentative;
    }
    /**
     * {@link #capital} の取得
     * @return {@link #capital}
     */
    public Long getCapital() {
        return this.capital;
    }
    /**
     * {@link #capital} の設定
     * @param aCapital {@link #capital}
     */
    public void setCapital(final Long aCapital) {
        this.capital = aCapital;
    }
    /**
     * {@link #accountingPeriod} の取得
     * @return {@link #accountingPeriod}
     */
    public Long getAccountingPeriod() {
        return this.accountingPeriod;
    }
    /**
     * {@link #accountingPeriod} の設定
     * @param aAccountingPeriod {@link #accountingPeriod}
     */
    public void setAccountingPeriod(final Long aAccountingPeriod) {
        this.accountingPeriod = aAccountingPeriod;
    }
    /**
     * {@link #listedSection} の取得
     * @return {@link #listedSection}
     */
    public ListedSection getListedSection() {
        return this.listedSection;
    }
    /**
     * {@link #listedSection} の設定
     * @param aListedSection {@link #listedSection}
     */
    public void setListedSection(final ListedSection aListedSection) {
        this.listedSection = aListedSection;
    }
}
