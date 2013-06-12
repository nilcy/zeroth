// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.infra.persistence;
import java.io.Serializable;
import javax.persistence.Query;
import zeroth.framework.enterprise.shared.Persistable;
/**
 * 原始データ永続化サービスI/F(JPA2/NativeQuery)
 * @param <E> エンティティ型
 * @param <ID> 識別子オブジェクト型
 * @author nilcy
 */
public interface NativePersistenceService<E extends Persistable<ID>, ID extends Serializable>
    extends SimplePersistenceService<E, ID> {
    /**
     * クエリの作成
     * @param sql SQL
     * @return クエリ
     */
    Query createNativeQuery(final String sql);
    /**
     * クエリの作成
     * @param sql SQL
     * @param resultClass 結果格納クラス
     * @return クエリ
     */
    Query createNativeQuery(final String sql, final Class<?> resultClass);
    /**
     * クエリの作成
     * @param sql SQL
     * @param resultSetMappingName 結果セットマッピング名
     * @return クエリ
     */
    Query createNativeQuery(final String sql, final String resultSetMappingName);
}
