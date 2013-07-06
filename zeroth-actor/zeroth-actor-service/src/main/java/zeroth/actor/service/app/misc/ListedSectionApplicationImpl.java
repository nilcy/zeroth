// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.app.misc;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.inject.Inject;
import zeroth.actor.service.domain.misc.ListedSection;
import zeroth.actor.service.domain.misc.ListedSectionRepository;
import zeroth.framework.enterprise.app.AbstractSimpleRepositoryApplication;
import zeroth.framework.enterprise.domain.SimpleRepository;
import zeroth.framework.enterprise.shared.Tracer;
import zeroth.framework.standard.shared.SimpleFilter;
/**
 * 上場先アプリケーション
 * @author nilcy
 */
@Stateless
// @Default
@Tracer
public class ListedSectionApplicationImpl extends
    AbstractSimpleRepositoryApplication<ListedSection, BigDecimal, SimpleFilter> implements
    ListedSectionApplication {
    /** 製品番号 */
    private static final long serialVersionUID = 2537651945740718957L;
    /** 上場先リポジトリ */
    @Inject
    private ListedSectionRepository repository;
    /** コンストラクタ */
    public ListedSectionApplicationImpl() {
    }
    /** {@inheritDoc} */
    @Override
    protected SimpleRepository<ListedSection, BigDecimal, SimpleFilter> getRepository() {
        return repository;
    }
}
