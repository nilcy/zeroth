// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.app.actor;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.inject.Inject;
import zeroth.actor.service.domain.Organ;
import zeroth.actor.service.domain.OrganRepository;
import zeroth.framework.enterprise.app.AbstractSimpleRepositoryApplication;
import zeroth.framework.enterprise.domain.SimpleRepository;
import zeroth.framework.enterprise.shared.Tracer;
import zeroth.framework.standard.shared.SimpleFilter;
/**
 * 組織アプリケーション
 * @author nilcy
 */
@Stateless
// @Default
@Tracer
public class OrganApplicationImpl extends
    AbstractSimpleRepositoryApplication<Organ, BigDecimal, SimpleFilter> implements
    OrganApplication {
    /** 製品番号 */
    private static final long serialVersionUID = 2537651945740718957L;
    /** 組織リポジトリ */
    @Inject
    private OrganRepository repository;
    /** コンストラクタ */
    public OrganApplicationImpl() {
    }
    /** {@inheritDoc} */
    @Override
    protected SimpleRepository<Organ, BigDecimal, SimpleFilter> getRepository() {
        return repository;
    }
}
