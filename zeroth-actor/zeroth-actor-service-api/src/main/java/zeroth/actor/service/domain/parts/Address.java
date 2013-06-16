// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.domain.parts;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import zeroth.framework.enterprise.domain.AbstractPersistable;
/**
 * 住所
 * @param <T> 住所オブジェクト型
 * @author nilcy
 */
@Entity
@Table(name = "address")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "address_type", discriminatorType = DiscriminatorType.STRING)
@Cacheable(true)
public class Address<T extends Address<T>> extends AbstractPersistable<T> {
    /** 製品番号 */
    private static final long serialVersionUID = -589669347532041227L;
    /** 住所宛名 */
    @Column(name = "name", nullable = false, insertable = true, updatable = true)
    private String name;
    /** 郵便番号 */
    @Column(name = "code", nullable = true, insertable = true, updatable = true)
    private String code;
    /** 都道府県 */
    @Column(name = "pref", nullable = true, insertable = true, updatable = true)
    private String pref;
    /** 市区町村 */
    @Column(name = "city", nullable = true, insertable = true, updatable = true)
    private String city;
    /** 町域 */
    @Column(name = "town", nullable = true, insertable = true, updatable = true)
    private String town;
    /** 丁目番地 */
    @Column(name = "street", nullable = true, insertable = true, updatable = true)
    private String street;
    /**
     * {@link #name} の取得
     * @return {@link #name}
     */
    public String getName() {
        return this.name;
    }
    /**
     * {@link #name} の設定
     * @param aName {@link #name}
     */
    public void setName(final String aName) {
        this.name = aName;
    }
    /**
     * {@link #code} の取得
     * @return {@link #code}
     */
    public String getCode() {
        return this.code;
    }
    /**
     * {@link #code} の設定
     * @param aCode {@link #code}
     */
    public void setCode(final String aCode) {
        this.code = aCode;
    }
    /**
     * {@link #pref} の取得
     * @return {@link #pref}
     */
    public String getPref() {
        return this.pref;
    }
    /**
     * {@link #pref} の設定
     * @param aPref {@link #pref}
     */
    public void setPref(final String aPref) {
        this.pref = aPref;
    }
    /**
     * {@link #city} の取得
     * @return {@link #city}
     */
    public String getCity() {
        return this.city;
    }
    /**
     * {@link #city} の設定
     * @param aCity {@link #city}
     */
    public void setCity(final String aCity) {
        this.city = aCity;
    }
    /**
     * {@link #town} の取得
     * @return {@link #town}
     */
    public String getTown() {
        return this.town;
    }
    /**
     * {@link #town} の設定
     * @param aTown {@link #town}
     */
    public void setTown(final String aTown) {
        this.town = aTown;
    }
    /**
     * {@link #street} の取得
     * @return {@link #street}
     */
    public String getStreet() {
        return this.street;
    }
    /**
     * {@link #street} の設定
     * @param aStreet {@link #street}
     */
    public void setStreet(final String aStreet) {
        this.street = aStreet;
    }
}
