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
import com.kuzumeji.domain.misc.NewsFactory;
import com.kuzumeji.entity.misc.News;
import zeroth.actor.screen.iface.jsf.AbstractActionImpl;
import zeroth.framework.enterprise.app.SimpleRepositoryService;
import zeroth.framework.enterprise.app.misc.NewsServiceLocal;
/**
 * News action.
 * @author nilcy
 */
@Named(value = "newsAction")
@ConversationScoped
@Default
public class NewsActionImpl extends AbstractActionImpl<News> implements NewsAction {
    /** S/N. */
    private static final long serialVersionUID = 7243039551620767571L;
    /** news service Local-I/F. */
    @EJB
    private NewsServiceLocal newsService;
    /** Constructor. */
    public NewsActionImpl() {
        super();
    }
    @Override
    public SimpleRepositoryService<News> getService() {
        return this.newsService;
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
