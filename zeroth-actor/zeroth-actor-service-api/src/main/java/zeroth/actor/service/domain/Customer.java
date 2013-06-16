// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.domain;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import zeroth.actor.service.domain.parts.CustomerContact;
/**
 * 得意先
 * @author nilcy
 */
@Entity
@Table(name = "customer")
@DiscriminatorValue("C")
@Cacheable(true)
public class Customer extends Company<Customer> {
    /** 製品番号 */
    private static final long serialVersionUID = 2288702045692529037L;
    /** 連絡先 */
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id", nullable = false, insertable = true, updatable = true)
    private CustomerContact contact;
    /** コンストラクタ */
    public Customer() {
    }
    /**
     * {@link #contact} の取得
     * @return {@link #contact}
     */
    public CustomerContact getContact() {
        return contact;
    }
    /**
     * {@link #contact} の設定
     * @param aContact {@link #contact}
     */
    public void setContact(final CustomerContact aContact) {
        contact = aContact;
    }
}
