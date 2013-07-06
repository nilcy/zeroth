// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.app.misc;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.inject.Inject;
import zeroth.actor.service.domain.misc.News;
import zeroth.actor.service.domain.misc.NewsRepository;
import zeroth.framework.enterprise.app.AbstractSimpleRepositoryApplication;
import zeroth.framework.enterprise.domain.SimpleRepository;
import zeroth.framework.enterprise.shared.Tracer;
import zeroth.framework.standard.shared.SimpleFilter;
/**
 * お知らせアプリケーション
 * @author nilcy
 */
@Stateless
// @Default
@Tracer
public class NewsApplicationImpl extends
    AbstractSimpleRepositoryApplication<News, BigDecimal, SimpleFilter> implements NewsApplication {
    /** 製品番号 */
    private static final long serialVersionUID = 7126614585601195838L;
    /** お知らせリポジトリ */
    @Inject
    private NewsRepository repository;
    /** コンストラクタ */
    public NewsApplicationImpl() {
    }
    /** {@inheritDoc} */
    @Override
    protected SimpleRepository<News, BigDecimal, SimpleFilter> getRepository() {
        return repository;
    }
}
