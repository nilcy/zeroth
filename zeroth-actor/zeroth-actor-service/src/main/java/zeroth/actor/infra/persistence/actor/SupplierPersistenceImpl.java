// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.infra.persistence.actor;
import javax.enterprise.inject.Default;
import zeroth.actor.entity.actor.Supplier;
/**
 * Supplier persistence implementation.
 * @author nilcy
 */
@Default
public class SupplierPersistenceImpl extends AbstractCompanyPersistence<Supplier> implements
    SupplierPersistence {
    /** 製品番号 */
    private static final long serialVersionUID = 278048625105529796L;
    /** コンストラクタ */
    public SupplierPersistenceImpl() {
        super();
    }
}
