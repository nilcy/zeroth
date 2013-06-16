// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.app.actor;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import zeroth.actor.service.app.actor.PartnerApplication;
import zeroth.actor.service.domain.Partner;
import zeroth.actor.service.domain.PartnerRepository;
import zeroth.framework.enterprise.app.AbstractSimpleRepositoryApplication;
import zeroth.framework.enterprise.domain.SimpleRepository;
import zeroth.framework.enterprise.shared.Tracer;
import zeroth.framework.standard.shared.SimpleFilter;
/**
 * 外注アプリケーション
 * @author nilcy
 */
@Stateless
@Default
@Tracer
public class PartnerApplicationImpl extends
    AbstractSimpleRepositoryApplication<Partner, Long, SimpleFilter> implements PartnerApplication {
    /** 製品番号 */
    private static final long serialVersionUID = -3688733534957646527L;
    /** 外注リポジトリ */
    @Inject
    private PartnerRepository repository;
    /** {@inheritDoc} */
    @Override
    protected SimpleRepository<Partner, Long, SimpleFilter> getRepository() {
        return repository;
    }
}
