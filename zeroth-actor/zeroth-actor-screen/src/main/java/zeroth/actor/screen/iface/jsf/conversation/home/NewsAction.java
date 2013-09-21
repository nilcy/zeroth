// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.screen.iface.jsf.conversation.home;
import java.math.BigDecimal;
import zeroth.actor.service.domain.misc.News;
import zeroth.framework.screen.iface.jsf.SimpleAction;
import zeroth.framework.standard.shared.SimpleFilter;
/**
 * お知らせアクションI/F
 * @author nilcy
 */
public interface NewsAction extends SimpleAction<News, BigDecimal, SimpleFilter> {
}
