// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.domain.actor;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import zeroth.actor.common.TraceLog;
import zeroth.actor.domain.AbstractCrudRepository;
import zeroth.actor.entity.actor.Supplier;
import zeroth.actor.infra.persistence.PersistenceSupport;
import zeroth.actor.infra.persistence.actor.SupplierPersistence;
/**
 * Supplier repository implementation.
 * @author nilcy
 */
@Default
@TraceLog
public class SupplierRepositoryImpl extends AbstractCrudRepository<Supplier> implements
    SupplierRepository {
    /** S/N. */
    private static final long serialVersionUID = 3003296026718089910L;
    /** supplier persistence I/F. */
    @Inject
    private SupplierPersistence helper;
    /** Constructor. */
    public SupplierRepositoryImpl() {
        super();
    }
    /**
     * {@inheritDoc} Get {@link #helper}.
     * @return {@inheritDoc}
     */
    @Override
    public PersistenceSupport<Supplier> getPersistenceSupport() {
        return this.helper;
    }
}
