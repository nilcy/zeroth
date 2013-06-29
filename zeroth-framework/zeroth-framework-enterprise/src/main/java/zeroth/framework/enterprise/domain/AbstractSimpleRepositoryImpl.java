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
import javax.persistence.EntityExistsException;
import javax.persistence.OptimisticLockException;
import org.apache.commons.lang3.Validate;
import zeroth.framework.enterprise.infra.persistence.SimplePersistenceService;
import zeroth.framework.enterprise.shared.Persistable;
import zeroth.framework.standard.shared.CommonUtils;
/**
 * 基本リポジトリ
 * @param <E> エンティティ型
 * @param <ID> 識別子オブジェクト型
 * @param <F> フィルタ型 TODO extends ValueObject<?>
 * @param <P> データ永続化サービス型
 * @author nilcy
 */
public abstract class AbstractSimpleRepositoryImpl<E extends Persistable<ID>, ID extends Serializable, F extends Serializable, P extends SimplePersistenceService<E, ID>>
    implements SimpleRepository<E, ID, F> {
    /** 識別番号 */
    private static final long serialVersionUID = -5578612922301298194L;
    /** 保護例外キー */
    private static final String KEY_LOCK_EXCEPTION = "LOCK_EXCEPTION";
    /** コンストラクタ */
    public AbstractSimpleRepositoryImpl() {
    }
    /**
     * {@inheritDoc}
     * <p>
     * 必要に応じて一意キー制約チェックを実行する。 管理エンティティの保存、または分離エンティティの保存を実行する。
     * </p>
     */
    @SuppressWarnings("unchecked")
    @Override
    public <S extends E> S save(final S entity) throws ConstraintsException {
        CommonUtils.notNull(entity);
        if (this instanceof ConstraintsUK) {
            ((ConstraintsUK<E>) this).validateUK(entity);
        }
        try {
            getPersistenceService().persist(entity);
            return entity;
        } catch (final EntityExistsException e) {
            return getPersistenceService().merge(entity);
        }
    }
    /** {@inheritDoc} */
    @Override
    public <S extends E> S saveAndFlush(final S entity) throws ConstraintsException {
        final S savedEntity = save(entity);
        getPersistenceService().flush();
        return savedEntity;
    }
    /** {@inheritDoc} */
    @Override
    public <S extends E> Collection<S> save(final Iterable<S> entities) throws ConstraintsException {
        final Collection<S> savedEntity = new ArrayList<>();
        for (final S entity : entities) {
            savedEntity.add(save(entity));
        }
        return savedEntity;
    }
    /** {@inheritDoc} */
    @Override
    public void delete(final ID id) throws ConstraintsException {
        Validate.notNull(id);
        delete(find(id));
    }
    /**
     * {@inheritDoc}
     * <p>
     * データ永続化サービスでエンティティを削除して同期する。
     * </p>
     */
    @Override
    @SuppressWarnings("unchecked")
    public <S extends E> void delete(final S entity) throws ConstraintsException {
        Validate.notNull(entity);
        if (this instanceof ConstraintsFK) {
            ((ConstraintsFK<E>) this).validateFK(entity);
        }
        try {
            getPersistenceService().remove(getPersistenceService().merge(entity));
        } catch (final OptimisticLockException e) {
            throw new ConstraintsException(KEY_LOCK_EXCEPTION);
        }
    }
    /** {@inheritDoc} */
    @Override
    public <S extends E> void delete(final Iterable<S> entities) throws ConstraintsException {
        for (final S entity : entities) {
            delete(entity);
        }
    }
    /** {@inheritDoc} */
    @Override
    public void flush() {
        getPersistenceService().flush();
    }
    /**
     * {@inheritDoc}
     * <p>
     * データ永続化サービスでエンティティを閲覧する。
     * </p>
     */
    @Override
    public E find(final ID id) {
        return getPersistenceService().find(id);
    }
    /**
     * {@inheritDoc}
     * <p>
     * 必要に応じてデータ永続化サービスを使用して実装すること。(実装しないとNULL)
     * </p>
     */
    @Override
    public E findOne(final F filter) {
        return null;
    }
    /**
     * {@inheritDoc}
     * <p>
     * 必要に応じてデータ永続化サービスを使用して実装すること。(実装しないと空リスト)
     * </p>
     */
    @Override
    public Collection<E> findMany(final F filter) {
        return Collections.emptyList();
    }
    /**
     * {@inheritDoc}
     * <p>
     * 必要に応じてデータ永続化サービスを使用して実装すること。(実装しないと0)
     * </p>
     */
    @Override
    public long count(final F filter) {
        return 0;
    }
    /** {@inheritDoc} */
    @Override
    public <S extends E> boolean exists(final S entity) {
        return getPersistenceService().contains(entity);
    }
    /**
     * データ永続化サービスの取得
     * @return データ永続化サービス
     */
    protected abstract P getPersistenceService();
}
