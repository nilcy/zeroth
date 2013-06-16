// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.domain.misc;
import static zeroth.actor.service.domain.misc.Notice_.*;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.apache.commons.lang3.StringUtils;
import zeroth.actor.service.domain.misc.Notice;
import zeroth.actor.service.domain.misc.PersistenceServiceAnnotation.NewsPersistenceService;
import zeroth.framework.enterprise.domain.AbstractQueryRepositoryImpl;
import zeroth.framework.enterprise.infra.persistence.QueryPersistenceService;
import zeroth.framework.enterprise.shared.Tracer;
import zeroth.framework.standard.shared.SimpleFilter;
/**
 * 告知リポジトリ
 * @param <E> 告知オブジェクト型
 * @author nilcy
 */
@Default
@Tracer
public class NoticeRepositoryImpl<E extends Notice<E>> extends
    AbstractQueryRepositoryImpl<E, Long, SimpleFilter> implements NoticeRepository<E> {
    /** 製品番号 */
    private static final long serialVersionUID = -3189348807017581607L;
    /** 先進データ永続化サービス */
    @Inject
    @NewsPersistenceService
    private QueryPersistenceService<E, Long> service;
    /** {@inheritDoc} */
    @Override
    protected QueryPersistenceService<E, Long> getPersistenceService() {
        return service;
    }
    /**
     * {@inheritDoc}
     * <dl>
     * <dt>事前条件</dt>
     * <dd>フィルタは非NULLであること。</dd>
     * <dt>事後条件</dt>
     * <dd>指定したキーワードを表題、説明、カテゴリの部分一致で検索条件とする。</dd>
     * </dl>
     */
    @Override
    protected Predicate expression(final SimpleFilter filter) {
        assert filter != null;
        if (StringUtils.isEmpty(filter.getKeyword())) {
            return super.expression(filter);
        }
        final CriteriaBuilder b = service.builder();
        final Root<E> r = service.root();
        return b.or(b.like(r.get(title), wrapWildcard(filter.getKeyword())),
            b.like(r.get(description), wrapWildcard(filter.getKeyword())),
            b.like(r.get(category), wrapWildcard(filter.getKeyword())));
    }
}
