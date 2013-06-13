// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.infra.persistence.actor;
import zeroth.actor.entity.actor.Member;
import zeroth.actor.infra.persistence.ConstraintsUK;
/**
 * Member persistence I/F.
 * @author nilcy
 */
public interface MemberPersistence extends StaffPersistence<Member>, ConstraintsUK<Member> {
}
