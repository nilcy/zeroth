// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.domain;
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
 * 職員
 * @param <T> 職員オブジェクト型
 * @author nilcy
 */
@Entity
@Table(name = "staff")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "staff_type", discriminatorType = DiscriminatorType.STRING)
@Cacheable(true)
public class Staff<T extends Staff<T>> extends AbstractPersistable<T> {
    /** 製品番号 */
    private static final long serialVersionUID = -6782665199241064589L;
    /** 姓 */
    @Column(name = "family_name", nullable = false, insertable = true, updatable = true)
    private String familyName;
    /** 名 */
    @Column(name = "given_name", nullable = true, insertable = true, updatable = true)
    private String givenName;
    /** 姓カナ */
    @Column(name = "family_alias", nullable = true, insertable = true, updatable = true)
    private String familyAlias;
    /** 名カナ */
    @Column(name = "given_alias", nullable = true, insertable = true, updatable = true)
    private String givenAlias;
    /**
     * {@link #familyName} の取得
     * @return {@link #familyName}
     */
    public String getFamilyName() {
        return this.familyName;
    }
    /**
     * {@link #familyName} の設定
     * @param aFamilyName {@link #familyName}
     */
    public void setFamilyName(final String aFamilyName) {
        this.familyName = aFamilyName;
    }
    /**
     * {@link #givenName} の取得
     * @return {@link #givenName}
     */
    public String getGivenName() {
        return this.givenName;
    }
    /**
     * {@link #givenName} の設定
     * @param aGivenName {@link #givenName}
     */
    public void setGivenName(final String aGivenName) {
        this.givenName = aGivenName;
    }
    /**
     * {@link #familyAlias} の取得
     * @return {@link #familyAlias}
     */
    public String getFamilyAlias() {
        return this.familyAlias;
    }
    /**
     * {@link #familyAlias} の設定
     * @param aFamilyAlias {@link #familyAlias}
     */
    public void setFamilyAlias(final String aFamilyAlias) {
        this.familyAlias = aFamilyAlias;
    }
    /**
     * {@link #givenAlias} の取得
     * @return {@link #givenAlias}
     */
    public String getGivenAlias() {
        return this.givenAlias;
    }
    /**
     * {@link #givenAlias} の設定
     * @param aGivenAlias {@link #givenAlias}
     */
    public void setGivenAlias(final String aGivenAlias) {
        this.givenAlias = aGivenAlias;
    }
}
