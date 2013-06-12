// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.app;
import java.io.Serializable;
import zeroth.framework.enterprise.domain.SimpleRepository;
import zeroth.framework.enterprise.shared.Persistable;
import zeroth.framework.standard.shared.ValueObject;
/**
 * 基本リポジトリサービスI/F
 * @param <E> エンティティ型
 * @param <ID> 識別子オブジェクト型
 * @param <F> 検索条件オブジェクト型
 * @author nilcy
 */
public interface SimpleRepositoryService<E extends Persistable<ID>, ID extends Serializable, F extends ValueObject<?>>
    extends SimpleRepository<E, ID, F> {
}
