// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.infra.persistence;
import java.io.Serializable;
import javax.ejb.Local;
import javax.persistence.Query;
import zeroth.framework.standard.domain.Persistable;
/**
 * 原始データ永続化サービスI/F(JPA2/NativeQuery)
 * @param <T> エンティティ型
 * @param <ID> 識別子オブジェクト型
 * @author nilcy
 */
@Local
public interface NativePersistenceService<T extends Persistable<ID>, ID extends Serializable>
    extends PersistenceService<T, ID> {
    /**
     * クエリの作成
     * @param aSQL SQL
     * @return クエリ
     */
    Query createNativeQuery(final String aSQL);
    /**
     * クエリの作成
     * @param aSQL SQL
     * @param aResultClass 結果格納クラス
     * @return クエリ
     */
    Query createNativeQuery(final String aSQL, final Class<?> aResultClass);
    /**
     * クエリの作成
     * @param aSQL SQL
     * @param aResultSetMappingName 結果セットマッピング名
     * @return クエリ
     */
    Query createNativeQuery(final String aSQL, final String aResultSetMappingName);
}
