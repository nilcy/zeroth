// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.app.ws.calc;
import javax.ejb.Local;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
/**
 * Calculator service I/F.
 * @author nilcy
 */
@Local
@WebService
public interface CalcService {
    /**
     * add.
     * @param aRequest {@link CalcRequest}
     * @return {@link CalcResponse}
     */
    @WebMethod
    CalcResponse add(@WebParam(name = "request") CalcRequest aRequest);
}
