// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.app.misc;
import javax.ejb.Local;
import zeroth.actor.service.domain.misc.News;
import zeroth.framework.enterprise.app.SimpleRepositoryApplication;
import zeroth.framework.standard.shared.SimpleFilter;
/**
 * お知らせアプリケーションI/F
 * @author nilcy
 */
@Local
public interface NewsApplication extends SimpleRepositoryApplication<News, Long, SimpleFilter> {
}
