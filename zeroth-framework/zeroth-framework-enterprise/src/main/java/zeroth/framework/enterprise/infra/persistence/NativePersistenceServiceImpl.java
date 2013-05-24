// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.infra.persistence;
import javax.ejb.Stateless;
import javax.persistence.Query;
import zeroth.framework.enterprise.domain.ReferenceObject;
/**
 * 拡張データ永続化サービス(JPA2/CriteriaQuery)
 * <p>
 * クエリオブジェクト@PofEAA の実装
 * </p>
 * @param <T> 参照オブジェクト型
 * @param <ID> 識別子オブジェクト型
 * @author nilcy
 */
@Stateless
public class NativePersistenceServiceImpl<T extends ReferenceObject<T, ID>, ID> extends
    AbstractPersistenceServiceImpl<T, ID> implements NativePersistenceService<T, ID> {
    /** 識別番号 */
    private static final long serialVersionUID = -1029454631523751121L;
    @Override
    public Query createNativeQuery(final String aSQL) {
        return this.manager.createNativeQuery(aSQL);
    }
    @Override
    public Query createNativeQuery(final String aSQL, final Class<?> aResultClass) {
        return this.manager.createNativeQuery(aSQL, aResultClass);
    }
    @Override
    public Query createNativeQuery(final String aSQL, final String aResultSetMappingName) {
        return this.manager.createNativeQuery(aSQL, aResultSetMappingName);
    }
}
