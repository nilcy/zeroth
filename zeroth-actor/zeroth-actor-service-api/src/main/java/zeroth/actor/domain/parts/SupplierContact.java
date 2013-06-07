// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.domain.parts;
import javax.persistence.Cacheable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
/**
 * 調達先連絡先
 * @author nilcy
 */
@Entity
@DiscriminatorValue("S")
@Cacheable(true)
public class SupplierContact extends Contact<SupplierContact> {
    /** 製品番号 */
    private static final long serialVersionUID = 6729705844248775458L;
}
