// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.screen.iface.jsf.conversation.home;
import java.util.Date;
import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Named;
import zeroth.actor.service.app.misc.NewsApplication;
import zeroth.actor.service.domain.misc.News;
import zeroth.actor.service.domain.misc.NewsFactory;
import zeroth.framework.enterprise.app.SimpleRepositoryApplication;
import zeroth.framework.screen.iface.jsf.AbstractActionImpl;
/**
 * News action.
 * @author nilcy
 */
@Named(value = "newsAction")
@ConversationScoped
@Default
public class NewsActionImpl extends AbstractActionImpl<News, Long, News> implements NewsAction {
    /** 製品番号 */
    private static final long serialVersionUID = 7243039551620767571L;
    /** news service Local-I/F. */
    @EJB
    private NewsApplication newsService;
    /** コンストラクタ */
    public NewsActionImpl() {
        super();
    }
    @Override
    public SimpleRepositoryApplication<News, Long, News> getService() {
        return newsService;
    }
    /**
     * {@inheritDoc}
     * <ul>
     * <li>set published date.</li>
     * </ul>
     * @return {@inheritDoc}
     */
    @Override
    protected News createInstance() {
        final News i = new NewsFactory().create();
        i.setPublished(new Date());
        return i;
    }
}
