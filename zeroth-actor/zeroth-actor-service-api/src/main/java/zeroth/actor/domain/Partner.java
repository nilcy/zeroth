// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.domain;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import zeroth.actor.domain.parts.PartnerContact;
/**
 * 外注
 * @author nilcy
 */
@Entity
@Table(name = "partner")
@DiscriminatorValue("P")
@Cacheable(true)
public class Partner extends Staff<Partner> {
    /** 製品番号 */
    private static final long serialVersionUID = -1454247381808191968L;
    /** 連絡先 */
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id", nullable = true, insertable = true, updatable = true)
    private PartnerContact contact;
    /**
     * {@link #contact} の取得
     * @return {@link #contact}
     */
    public PartnerContact getContact() {
        return contact;
    }
    /**
     * {@link #contact} の設定
     * @param aContact {@link #contact}
     */
    public void setContact(final PartnerContact aContact) {
        contact = aContact;
    }
}
