// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.domain.parts;
import javax.persistence.Cacheable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
/**
 * 外注連絡先
 * @author nilcy
 */
@Entity
@DiscriminatorValue("P")
@Cacheable(true)
public class PartnerContact extends Contact<PartnerContact> {
    /** 製品番号 */
    private static final long serialVersionUID = 6729705844248775458L;
}
