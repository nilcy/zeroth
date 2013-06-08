// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.infra.persistence;
import java.io.Serializable;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.persistence.Query;
import zeroth.framework.enterprise.domain.Persistable;
/**
 * 拡張データ永続化サービス(JPA2/NativeQuery)
 * @param <E> エンティティ型
 * @param <ID> 識別子オブジェクト型
 * @author nilcy
 */
@Stateless
@Alternative
public class NativePersistenceServiceImpl<E extends Persistable<ID>, ID extends Serializable>
    extends PersistenceServiceImpl<E, ID> implements NativePersistenceService<E, ID> {
    /** 識別番号 */
    private static final long serialVersionUID = -1029454631523751121L;
    @Override
    public Query createNativeQuery(final String sql) {
        return manager.createNativeQuery(sql);
    }
    @Override
    public Query createNativeQuery(final String sql, final Class<?> resultClass) {
        return manager.createNativeQuery(sql, resultClass);
    }
    @Override
    public Query createNativeQuery(final String sql, final String resultSetMappingName) {
        return manager.createNativeQuery(sql, resultSetMappingName);
    }
}
