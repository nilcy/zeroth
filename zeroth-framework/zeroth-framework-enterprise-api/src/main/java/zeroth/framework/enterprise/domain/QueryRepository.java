// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
import java.io.Serializable;
import zeroth.framework.enterprise.shared.Persistable;
/**
 * 先進リポジトリI/F(JPA2/CriteriaQuery)
 * @param <E> エンティティ型
 * @param <ID> 識別子オブジェクト型
 * @param <F> 検索条件オブジェクト型 TODO extends ValueObject<?>
 * @author nilcy
 */
public interface QueryRepository<E extends Persistable<ID>, ID extends Serializable, F extends Serializable>
    extends SimpleRepository<E, ID, F> {
}