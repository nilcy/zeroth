// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.service.app;
import javax.ejb.Local;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import zeroth.framework.standard.app.GatewayModel;
/**
 * Gateway service I/F.
 * @author nilcy
 */
@Local
@WebService
public interface GatewayService {
    /**
     * Submit.
     * @param aGatewayRequest gateway request
     * @return gateway response
     */
    @WebMethod
    GatewayModel submit(@WebParam(name = "request") GatewayModel aGatewayRequest);
}
