// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.screen.iface.web.rest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
/**
 * Throw this exception to return a 401 Unauthorized response.
 * @author nilcy
 */
public class UnauthorizedException extends WebApplicationException {
    /** S/N. */
    private static final long serialVersionUID = -6796772574451059099L;
    /** Constructor. */
    public UnauthorizedException() {
        this("Please authenticate.", "Name of your web service");
    }
    /**
     * Constructor.
     * @param message message
     * @param realm realm
     */
    public UnauthorizedException(final String message, final String realm) {
        super(Response.status(Status.UNAUTHORIZED)
            .header(HttpHeaders.WWW_AUTHENTICATE, "Basic realm=\"" + realm + "\"").entity(message)
            .build());
    }
}
