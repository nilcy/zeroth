// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.domain.parts;
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
 * 連絡先
 * @param <T> 連絡先オブジェクト型
 * @author nilcy
 */
@Entity
@Table(name = "contact")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "contact_type", discriminatorType = DiscriminatorType.STRING)
@Cacheable(true)
public class Contact<T extends Contact<T>> extends AbstractPersistable<T> {
    /** 製品番号 */
    private static final long serialVersionUID = 1317514060244911729L;
    /** 連絡先宛名 */
    @Column(name = "name", nullable = false, insertable = true, updatable = true)
    private String name;
    /** 電話番号 */
    @Column(name = "telno", nullable = true, insertable = true, updatable = true)
    private String telno;
    /** 携帯番号 */
    @Column(name = "cellno", nullable = true, insertable = true, updatable = true)
    private String cellno;
    /** FAX番号 */
    @Column(name = "faxno", nullable = true, insertable = true, updatable = true)
    private String faxno;
    /** メールアドレス */
    @Column(name = "email", nullable = true, insertable = true, updatable = true)
    private String email;
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
    /**
     * @param aName
     */
    public void setName(final String aName) {
        this.name = aName;
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
     * {@link #cellno} の取得
     * @return {@link #cellno}
     */
    public String getCellno() {
        return this.cellno;
    }
    /**
     * {@link #cellno} の設定
     * @param aCellno {@link #cellno}
     */
    public void setCellno(final String aCellno) {
        this.cellno = aCellno;
    }
    /**
     * {@link #faxno} の取得
     * @return {@link #faxno}
     */
    public String getFaxno() {
        return this.faxno;
    }
    /**
     * {@link #faxno} の設定
     * @param aFaxno {@link #faxno}
     */
    public void setFaxno(final String aFaxno) {
        this.faxno = aFaxno;
    }
    /**
     * {@link #email} の取得
     * @return {@link #email}
     */
    public String getEmail() {
        return this.email;
    }
    /**
     * {@link #email} の設定
     * @param aEmail {@link #email}
     */
    public void setEmail(final String aEmail) {
        this.email = aEmail;
    }
}
