// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.app.actor;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import zeroth.actor.app.AbstractCrudService;
import zeroth.actor.common.TraceLog;
import zeroth.actor.domain.Repository;
import zeroth.actor.domain.SupplierRepository;
import zeroth.actor.entity.actor.Supplier;
/**
 * Supplier service implementation.
 * @author nilcy
 */
@Stateless
@Default
@TraceLog
public class SupplierServiceImpl extends AbstractCrudService<Supplier> implements
    SupplierServiceLocal {
    /** 製品番号 */
    private static final long serialVersionUID = 2537651945740718957L;
    /** supplier repository I/F. */
    @Inject
    private SupplierRepository repository;
    /** コンストラクタ */
    public SupplierServiceImpl() {
        super();
    }
    /**
     * {@inheritDoc} Get {@link #repository}.
     */
    @Override
    protected Repository<Supplier> getRepository() {
        return this.repository;
    }
}
