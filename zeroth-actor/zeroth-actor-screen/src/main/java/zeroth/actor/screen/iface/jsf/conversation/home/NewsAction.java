// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.screen.iface.jsf.conversation.home;
import zeroth.actor.service.domain.misc.News;
import zeroth.framework.screen.iface.jsf.Action;
import zeroth.framework.standard.shared.SimpleFilter;
/**
 * New Action I/F.
 * @author nilcy
 */
public interface NewsAction extends Action<News, Long, SimpleFilter> {
}
