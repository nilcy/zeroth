// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.app.actor;
import java.math.BigDecimal;
import javax.ejb.Local;
import zeroth.actor.service.domain.Member;
import zeroth.actor.service.domain.MemberFilter;
import zeroth.framework.enterprise.app.SimpleRepositoryApplication;
/**
 * 社員アプリケーションI/F
 * @author nilcy
 */
@Local
public interface MemberApplication extends
    SimpleRepositoryApplication<Member, BigDecimal, MemberFilter> {
}
