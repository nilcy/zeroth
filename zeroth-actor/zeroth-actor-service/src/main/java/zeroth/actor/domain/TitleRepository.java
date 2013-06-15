// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.domain;
import zeroth.framework.enterprise.domain.QueryRepository;
import zeroth.framework.standard.shared.SimpleFilter;
/**
 * 職名リポジトリI/F
 * @author nilcy
 */
public interface TitleRepository extends QueryRepository<Title, Long, SimpleFilter> {
}
