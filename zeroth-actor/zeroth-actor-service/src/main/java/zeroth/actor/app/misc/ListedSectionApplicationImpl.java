// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.app.misc;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import zeroth.actor.domain.misc.ListedSection;
import zeroth.actor.domain.misc.ListedSectionRepository;
import zeroth.framework.enterprise.app.AbstractSimpleRepositoryApplication;
import zeroth.framework.enterprise.domain.SimpleRepository;
import zeroth.framework.enterprise.shared.Tracer;
import zeroth.framework.standard.shared.SimpleFilter;
/**
 * 上場先アプリケーション
 * @author nilcy
 */
@Stateless
@Default
@Tracer
public class ListedSectionApplicationImpl extends
    AbstractSimpleRepositoryApplication<ListedSection, Long, SimpleFilter> implements
    ListedSectionApplication {
    /** 製品番号 */
    private static final long serialVersionUID = 2537651945740718957L;
    /** 上場先リポジトリ */
    @Inject
    private ListedSectionRepository repository;
    /** {@inheritDoc} */
    @Override
    protected SimpleRepository<ListedSection, Long, SimpleFilter> getRepository() {
        return repository;
    }
}
