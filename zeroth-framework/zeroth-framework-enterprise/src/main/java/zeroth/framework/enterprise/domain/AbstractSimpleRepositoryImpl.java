// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import zeroth.framework.enterprise.infra.persistence.PersistenceService;
/**
 * 基本リポジトリ
 * @param <T> エンティティ型
 * @param <ID> 識別子オブジェクト型
 * @param <F> フィルタ型
 * @author nilcy
 */
public abstract class AbstractSimpleRepositoryImpl<T extends Persistable<ID>, ID extends Serializable, F extends Object>
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
     * データ永続化サービスの取得
     * @return データ永続化サービス
     */
    protected abstract PersistenceService<T, ID> getPersistenceService();
}
