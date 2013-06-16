// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.domain;
import zeroth.framework.enterprise.domain.SimpleRepository;
/**
 * 社員リポジトリI/F
 * @author nilcy
 */
public interface MemberRepository extends SimpleRepository<Member, Long, MemberFilter> {
}
