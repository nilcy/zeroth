// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.app.actor;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.inject.Inject;
import zeroth.actor.service.domain.Supplier;
import zeroth.actor.service.domain.SupplierRepository;
import zeroth.framework.enterprise.app.AbstractSimpleRepositoryApplication;
import zeroth.framework.enterprise.domain.SimpleRepository;
import zeroth.framework.enterprise.shared.Tracer;
import zeroth.framework.standard.shared.SimpleFilter;
/**
 * 調達先アプリケーション
 * @author nilcy
 */
@Stateless
// @Default
@Tracer
public class SupplierApplicationImpl extends
    AbstractSimpleRepositoryApplication<Supplier, BigDecimal, SimpleFilter> implements
    SupplierApplication {
    /** 製品番号 */
    private static final long serialVersionUID = 2537651945740718957L;
    /** 調達先リポジトリ */
    @Inject
    private SupplierRepository repository;
    /** コンストラクタ */
    public SupplierApplicationImpl() {
    }
    /** {@inheritDoc} */
    @Override
    protected SimpleRepository<Supplier, BigDecimal, SimpleFilter> getRepository() {
        return repository;
    }
}
