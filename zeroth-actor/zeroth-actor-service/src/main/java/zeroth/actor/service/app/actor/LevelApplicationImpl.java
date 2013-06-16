// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.app.actor;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import zeroth.actor.service.app.actor.LevelApplication;
import zeroth.actor.service.domain.Level;
import zeroth.actor.service.domain.LevelRepository;
import zeroth.framework.enterprise.app.AbstractSimpleRepositoryApplication;
import zeroth.framework.enterprise.domain.SimpleRepository;
import zeroth.framework.enterprise.shared.Tracer;
import zeroth.framework.standard.shared.SimpleFilter;
/**
 * 職級アプリケーション
 * @author nilcy
 */
@Stateless
@Default
@Tracer
public class LevelApplicationImpl extends
    AbstractSimpleRepositoryApplication<Level, Long, SimpleFilter> implements LevelApplication {
    /** 製品番号 */
    private static final long serialVersionUID = -3833130543168027472L;
    /** 職級リポジトリ */
    @Inject
    private LevelRepository repository;
    /** {@inheritDoc} */
    @Override
    protected SimpleRepository<Level, Long, SimpleFilter> getRepository() {
        return repository;
    }
}
