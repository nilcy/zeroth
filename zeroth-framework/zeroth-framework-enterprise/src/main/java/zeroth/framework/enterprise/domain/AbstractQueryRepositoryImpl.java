// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.Predicate;
import zeroth.framework.enterprise.infra.persistence.QueryPersistenceService;
import zeroth.framework.enterprise.shared.Persistable;
import zeroth.framework.standard.shared.WithPageRequest;
/**
 * 先進リポジトリ
 * @param <E> エンティティ型
 * @param <ID> 識別子オブジェクト型
 * @param <F> フィルタ型 TODO extends ValueObject<?>
 * @author nilcy
 */
public abstract class AbstractQueryRepositoryImpl<E extends Persistable<ID>, ID extends Serializable, F extends Serializable>
    extends AbstractSimpleRepositoryImpl<E, ID, F, QueryPersistenceService<E, ID>> {
    /** 識別番号 */
    private static final long serialVersionUID = -5208804239051677983L;
    /** あいまい検索ワイルドカード(0文字以上の文字列) */
    protected static final char WILDCARD_MULTI = '%';
    /** あいまい検索ワイルドカード(任意の1文字) */
    protected static final char WILDCARD_SINGLE = '_';
    /** コンストラクタ */
    public AbstractQueryRepositoryImpl() {
    }
    /** {@inheritDoc} */
    @Override
    public final E findOne(final F filter) {
        return createQuery(filter).getSingleResult();
    }
    /** {@inheritDoc} */
    @Override
    public final Collection<E> findMany(final F filter) {
        return createQuery(filter).getResultList();
    }
    /** {@inheritDoc} */
    @Override
    public final long count(final F filter) {
        return getPersistenceService().createCountQuery(expression(filter)).getSingleResult()
            .longValue();
    }
    /**
     * クエリの作成
     * @param filter 抽出条件
     * @return クエリ
     */
    private TypedQuery<E> createQuery(final F filter) {
        getPersistenceService().query().select(getPersistenceService().root())
            .where(expression(filter));
        if (filter instanceof WithPageRequest) {
            return getPersistenceService().createQuery(((WithPageRequest) filter).getPageRequest());
        }
        return getPersistenceService().createQuery();
    }
    /**
     * WHERE句の作成
     * <p>
     * 必要に応じてWHERE句を実装すること。(実装しないと無条件)
     * </p>
     * @param filter 検索条件
     * @return WHERE句
     */
    protected Predicate expression(final F filter) {
        return getPersistenceService().builder().conjunction();
    }
    /**
     * ワイルドカードのラップ
     * <dl>
     * <dt>事前条件</dt>
     * <dd>文字列は非NULLであること。</dd>
     * </dl>
     * @param value 文字列
     * @return %文字列%
     */
    protected static String wrapWildcard(final String value) {
        assert value != null;
        return WILDCARD_MULTI + value + WILDCARD_MULTI;
    }
}
