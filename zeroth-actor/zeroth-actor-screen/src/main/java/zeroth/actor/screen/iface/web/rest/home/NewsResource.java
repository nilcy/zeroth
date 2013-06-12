// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.screen.iface.web.rest.home;
import java.util.Collection;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import com.kuzumeji.entity.misc.News;
import com.kuzumeji.persistence.ConstraintsException;
import zeroth.actor.screen.iface.web.rest.ResourceException;
import zeroth.actor.screen.iface.web.rest.ResourceFault;
import zeroth.framework.enterprise.app.misc.NewsServiceLocal;
/**
 * News resources.
 * @author nilcy
 */
@Path("/home/news")
@RequestScoped
public class NewsResource {
    /** news service Local-I/F. */
    @EJB
    private NewsServiceLocal newsService;
    /** logger. */
    @Inject
    private Logger log;
    /** Constructor. */
    public NewsResource() {
        super();
    }
    /**
     * Get news list.
     * @return news list
     */
    @GET
    @Path("/")
    @Produces({ MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
    public Collection<News> getList() {
        return this.newsService.find();
    }
    /**
     * Get news.
     * @param aId ID
     * @return news
     */
    @GET
    @Path("/{id}")
    @Produces({ MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
    public News getItem(@PathParam("id") final Long aId) {
        final News item = this.newsService.find(aId);
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
            this.newsService.save(aNews);
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
    public void deleteItem(@PathParam("id") final Long aId) {
        try {
            this.newsService.delete(this.newsService.find(aId));
        } catch (final ConstraintsException e) {
            throw new ResourceException(new ResourceFault("ERR003", "DELETE_ERROR"));
        }
    }
}