// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import zeroth.framework.enterprise.infra.persistence.PersistenceService;
import zeroth.framework.standard.shared.Pageable;
import zeroth.framework.standard.shared.Sort.Direction;
import zeroth.framework.standard.shared.Sort.Order;
import zeroth.framework.standard.shared.ValueObject;
/**
 * 基本リポジトリ
 * @param <T> エンティティ型
 * @param <ID> 識別子オブジェクト型
 * @param <F> フィルタ型
 * @author nilcy
 */
public abstract class AbstractSimpleRepositoryImpl<T extends Persistable<ID>, ID extends Serializable, F extends ValueObject<?>>
    implements SimpleRepository<T, ID, F> {
    /** 識別番号 */
    private static final long serialVersionUID = -5578612922301298194L;
    /** コンストラクタ */
    public AbstractSimpleRepositoryImpl() {
    }
    /**
     * {@inheritDoc}
     * <p>
     * データ永続化サービスでエンティティを登録して同期する。
     * </p>
     */
    @Override
    public void save(final T entity) {
        getPersistenceService().persist(entity);
        getPersistenceService().flush();
    }
    /**
     * {@inheritDoc}
     * <p>
     * データ永続化サービスでエンティティを削除して同期する。
     * </p>
     */
    @Override
    public void delete(final T entity) {
        getPersistenceService().remove(entity);
        getPersistenceService().flush();
    }
    /**
     * {@inheritDoc}
     * <p>
     * データ永続化サービスでエンティティを閲覧する。
     * </p>
     */
    @Override
    public T find(final ID id) {
        return getPersistenceService().find(id);
    }
    /**
     * {@inheritDoc}
     * <p>
     * 必要に応じてデータ永続化サービスを使用して実装すること。(実装しないとNULL)
     * </p>
     */
    @Override
    public T findOne(final F filter) {
        return null;
    }
    /**
     * {@inheritDoc}
     * <p>
     * 必要に応じてデータ永続化サービスを使用して実装すること。(実装しないと空リスト)
     * </p>
     */
    @Override
    public Collection<T> findMany(final F filter) {
        return Collections.emptyList();
    }
    /**
     * {@inheritDoc} *
     * <p>
     * 必要に応じてデータ永続化サービスを使用して実装すること。(実装しないと0)
     * </p>
     */
    @Override
    public long count(final F filter) {
        return 0;
    }
    /**
     * データ永続化サービスの取得
     * @return データ永続化サービス
     */
    protected abstract PersistenceService<T, ID> getPersistenceService();
    /**
     * ソート条件の設定
     * @param builder 標準ビルダー
     * @param root 標準ルート
     * @param query 標準クエリ
     * @param pageable ページI/F
     */
    protected static void setOrder(final CriteriaBuilder builder, final Root<?> root,
        final CriteriaQuery<?> query, final Pageable pageable) {
        if (pageable.getSort() != null) {
            final Collection<javax.persistence.criteria.Order> criteriaOrders = new ArrayList<>();
            for (final Iterator<Order> iter = pageable.getSort().iterator(); iter.hasNext();) {
                final Order order = iter.next();
                if (Direction.ASC.equals(order.getDirection())) {
                    criteriaOrders.add(builder.asc(root.get(order.getProperty())));
                } else {
                    criteriaOrders.add(builder.desc(root.get(order.getProperty())));
                }
            }
            query.orderBy(criteriaOrders.toArray(new javax.persistence.criteria.Order[0]));
        }
    }
}
