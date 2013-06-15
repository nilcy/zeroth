// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.domain.misc;
import zeroth.framework.enterprise.domain.QueryRepository;
import zeroth.framework.standard.shared.SimpleFilter;
/**
 * 告知リポジトリI/F
 * @param <E> 告知オブジェクト型
 * @author nilcy
 */
public interface NoticeRepository<E extends Notice<E>> extends
    QueryRepository<E, Long, SimpleFilter> {
}
