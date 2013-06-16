// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.app.actor;
import javax.ejb.Local;
import zeroth.actor.service.domain.Partner;
import zeroth.framework.enterprise.app.SimpleRepositoryApplication;
import zeroth.framework.standard.shared.SimpleFilter;
/**
 * 外注アプリケーションI/F
 * @author nilcy
 */
@Local
public interface PartnerApplication extends
    SimpleRepositoryApplication<Partner, Long, SimpleFilter> {
}
