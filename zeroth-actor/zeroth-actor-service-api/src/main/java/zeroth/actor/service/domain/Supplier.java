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
import zeroth.actor.service.domain.parts.SupplierContact;
/**
 * 調達先
 * @author nilcy
 */
@Entity
@Table(name = "supplier")
@DiscriminatorValue("S")
@Cacheable(true)
public class Supplier extends Company<Supplier> {
    /** 製品番号 */
    private static final long serialVersionUID = 7929822997774039779L;
    /** 連絡先 */
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id", nullable = true, insertable = true, updatable = true)
    private SupplierContact contact;
    /**
     * {@link #contact} の取得
     * @return {@link #contact}
     */
    public SupplierContact getContact() {
        return contact;
    }
    /**
     * {@link #contact} の設定
     * @param aContact {@link #contact}
     */
    public void setContact(final SupplierContact aContact) {
        contact = aContact;
    }
}
