// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.screen.iface.web.rest.home;
import java.math.BigDecimal;
import java.util.Collection;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import zeroth.actor.screen.iface.web.rest.ResourceException;
import zeroth.actor.screen.iface.web.rest.ResourceFault;
import zeroth.actor.service.app.misc.NewsApplication;
import zeroth.actor.service.domain.misc.News;
import zeroth.framework.enterprise.domain.ConstraintsException;
/**
 * News resources.
 * @author nilcy
 */
@Path("/home/news")
@RequestScoped
public class NewsResource {
    /** news service Local-I/F. */
    @EJB
    private NewsApplication newsService;
    /** ロガー */
    // private final Logger log = Logger.getGlobal();
    /** コンストラクタ */
    public NewsResource() {
        super();
    }
    /**
     * news list.
     * @return news list
     */
    @GET
    @Path("/")
    @Produces({ MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
    public Collection<News> getList() {
        return newsService.findMany(null);
    }
    /**
     * news.
     * @param aId ID
     * @return news
     */
    @GET
    @Path("/{id}")
    @Produces({ MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
    public News getItem(@PathParam("id") final BigDecimal aId) {
        final News item = newsService.find(aId);
        if (item == null) {
            throw new ResourceException(new ResourceFault("ERR001", "GET_ERROR"));
        }
        return item;
    }
    /**
     * Post news.
     * @param aNews news
     */
    @POST
    @Path("/")
    @Consumes({ MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
    public void postItem(final News aNews) {
        try {
            newsService.save(aNews);
        } catch (final ConstraintsException e) {
            throw new ResourceException(new ResourceFault("ERR002", "POST_ERROR"));
        }
    }
    /**
     * Delete news.
     * @param aId ID
     */
    @DELETE
    @Path("/{id}")
    @Consumes({ MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
    public void deleteItem(@PathParam("id") final BigDecimal aId) {
        try {
            newsService.delete(newsService.find(aId));
        } catch (final ConstraintsException e) {
            throw new ResourceException(new ResourceFault("ERR003", "DELETE_ERROR"));
        }
    }
}
