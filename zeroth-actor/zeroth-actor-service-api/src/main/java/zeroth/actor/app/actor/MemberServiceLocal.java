// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.app.actor;
import javax.ejb.Local;
import zeroth.actor.domain.Member;
import zeroth.framework.enterprise.app.SimpleRepositoryService;
/**
 * Member service Local-I/F.
 * @author nilcy
 */
@Local
public interface MemberServiceLocal extends SimpleRepositoryService<Member, Long, Member> {
}
