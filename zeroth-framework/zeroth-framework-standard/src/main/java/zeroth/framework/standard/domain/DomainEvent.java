// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.domain;

import zeroth.framework.standard.shared.DataObject;

/**
 * ドメインイベント
 * @param <T> ドメインイベント型
 * @author nilcy
 */
public interface DomainEvent<T extends DomainEvent<T>> extends DataObject<T> {
    /**
     * 同一性の確認
     * @param aOther 比較するドメインイベント
     * @return 同一なとき真。同一でないとき偽。
     */
    boolean sameEventAs(T aOther);
}
