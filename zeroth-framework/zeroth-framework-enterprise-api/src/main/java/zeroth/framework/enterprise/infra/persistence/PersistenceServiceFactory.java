// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.infra.persistence;
import java.io.Serializable;
import javax.persistence.EntityManager;
import zeroth.framework.enterprise.shared.Persistable;
/**
 * データ永続化サービスのファクトリI/F
 * @author nilcy
 */
public interface PersistenceServiceFactory {
    /**
     * 基本データ永続化サービスの作成
     * @param manager エンティティマネージャ
     * @param clazz エンティティクラス
     * @return 基本データ永続化サービスI/F
     */
    <E extends Persistable<ID>, ID extends Serializable> SimplePersistenceService<E, ID> createSimplePersistenceService(
        EntityManager manager, Class<E> clazz);
    /**
     * 原紙データ永続化サービスの作成
     * @param manager エンティティマネージャ
     * @param clazz エンティティクラス
     * @return 原紙データ永続化サービスI/F
     */
    <E extends Persistable<ID>, ID extends Serializable> NativePersistenceService<E, ID> createNativePersistenceService(
        EntityManager manager, Class<E> clazz);
    /**
     * 標準データ永続化サービスの作成
     * @param manager エンティティマネージャ
     * @param clazz エンティティクラス
     * @return 標準データ永続化サービスI/F
     */
    <E extends Persistable<ID>, ID extends Serializable> StandardPersistenceService<E, ID> createStandardPersistenceService(
        EntityManager manager, Class<E> clazz);
    /**
     * 拡張データ永続化サービスの作成
     * @param manager エンティティマネージャ
     * @param clazz エンティティクラス
     * @return 拡張データ永続化サービスI/F
     */
    <E extends Persistable<ID>, ID extends Serializable> QueryPersistenceService<E, ID> createQueryPersistenceService(
        EntityManager manager, Class<E> clazz);
}
