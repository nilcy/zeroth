// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.screen.iface.web.rest;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
/**
 * Thrown to return a 400 Bad Request response with a list of error messages in
 * the body.
 * @author nilcy
 */
public class BadRequestException extends WebApplicationException {
    /** 製品番号 */
    private static final long serialVersionUID = -3044929615860691176L;
    /** Errors. */
    private final List<String> errors;
    /**
     * コンストラクタ
     * @param aErrors errors
     */
    public BadRequestException(final String... aErrors) {
        this(Arrays.asList(aErrors));
    }
    /**
     * コンストラクタ
     * @param aErrors errors
     */
    public BadRequestException(final List<String> aErrors) {
        super(Response.status(Status.BAD_REQUEST).type(MediaType.APPLICATION_XHTML_XML)
            .entity(new GenericEntity<List<String>>(aErrors) {
            }).build());
        this.errors = aErrors;
    }
    /**
     * errors.
     * @return errors
     */
    public List<String> getErrors() {
        return this.errors;
    }
}
