// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.infra.persistence;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import zeroth.framework.enterprise.domain.ReferenceObject;
/**
 * 標準データ永続化サービス(JPA2/JPQL)
 * @param <T> 参照オブジェクト型
 * @param <ID> 識別子オブジェクト型
 * @author nilcy
 */
@Stateless
public class StandardPersistenceServiceImpl<T extends ReferenceObject<T, ID>, ID> extends
    AbstractPersistenceServiceImpl<T, ID> implements StandardPersistenceService<T, ID> {
    /** 識別番号 */
    private static final long serialVersionUID = -1029454631523751121L;
    @Override
    public TypedQuery<T> createQuery(final String aJPQL) {
        return this.manager.createQuery(aJPQL, super.clazz);
    }
    @Override
    public TypedQuery<T> createNamedQuery(final String aQueryName) {
        return this.manager.createNamedQuery(aQueryName, super.clazz);
    }
}
