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
 * 事務所住所
 * @author nilcy
 */
@Entity
@DiscriminatorValue("O")
@Cacheable(true)
public class OfficeAddress extends Address<OfficeAddress> {
    /** 製品番号 */
    private static final long serialVersionUID = -549910234465549139L;
}
