// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.screen.iface.web.rest;
import java.net.URI;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
/**
 * Thrown to return a 409 Conflict response with optional Location header and
 * entity.
 * @author nilcy
 */
public class ConflictException extends WebApplicationException {
    /** S/N. */
    private static final long serialVersionUID = -3079453625686757347L;
    /** Constructor. */
    public ConflictException() {
        this(null, null);
    }
    /**
     * Constructor.
     * @param aLocation location
     */
    public ConflictException(final URI aLocation) {
        this(aLocation, null);
    }
    /**
     * Constructor.
     * @param aLocation location
     * @param aEntity entity
     */
    public ConflictException(final URI aLocation, final Object aEntity) {
        super(Response.status(Status.CONFLICT).location(aLocation).entity(aEntity).build());
    }
}
