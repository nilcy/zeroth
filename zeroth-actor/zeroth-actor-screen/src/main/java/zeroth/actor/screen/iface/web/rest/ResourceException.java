// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.screen.iface.web.rest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
/**
 * Resource exception.
 * @author nilcy
 */
public class ResourceException extends WebApplicationException {
    /** S/N. */
    private static final long serialVersionUID = -6533374162841417982L;
    /**
     * Constructor.
     * @param aFault resource fault
     */
    public ResourceException(final ResourceFault aFault) {
        super(Response.status(Status.BAD_REQUEST).entity(aFault).type(MediaType.TEXT_XML).build());
    }
}
