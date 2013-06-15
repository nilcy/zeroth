// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.app.misc;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import zeroth.actor.app.AbstractCrudService;
import zeroth.actor.common.TraceLog;
import zeroth.actor.domain.Repository;
import zeroth.actor.domain.misc.NewsRepository;
import zeroth.actor.entity.misc.News;
/**
 * News service implementation.
 * @author nilcy
 */
@Stateless
@Default
@TraceLog
public class NewsServiceImpl extends AbstractCrudService<News> implements NewsServiceLocal {
    /** 製品番号 */
    private static final long serialVersionUID = 7126614585601195838L;
    /** news repository I/F. */
    @Inject
    private NewsRepository repository;
    /** コンストラクタ */
    public NewsServiceImpl() {
        super();
    }
    /**
     * {@inheritDoc} Get {@link #repository}.
     */
    @Override
    protected Repository<News> getRepository() {
        return this.repository;
    }
}
