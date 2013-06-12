// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
import zeroth.framework.enterprise.shared.Persistable;
/**
 * 外部キー制約チェックI/F
 * @param <E> エンティティ型
 * @author nilcy
 */
public interface ConstraintsFK<E extends Persistable<?>> {
    /**
     * 外部キー制約チェック処理
     * @param entity エンティティ
     * @throws ConstraintsException 制約違反キャッチ例外
     */
    void validateFK(final E entity) throws ConstraintsException;
}
