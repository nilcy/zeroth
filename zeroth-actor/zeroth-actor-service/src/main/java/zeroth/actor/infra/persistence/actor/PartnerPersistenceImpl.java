// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.infra.persistence.actor;
import javax.enterprise.inject.Default;
import zeroth.actor.entity.actor.Partner;
/**
 * Partner persistence implementation.
 * @author nilcy
 */
@Default
public class PartnerPersistenceImpl extends AbstractStaffPersistence<Partner> implements
    PartnerPersistence {
    /** 製品番号 */
    private static final long serialVersionUID = 2426399469775914866L;
    /** コンストラクタ */
    public PartnerPersistenceImpl() {
        super();
    }
}
