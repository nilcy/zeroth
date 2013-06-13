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
 * ゲートウェイサービスI/F
 * @author nilcy
 */
@Local
@WebService
public interface GatewayService {
    /**
     * RPCサービスの実行
     * @param request RPCサービスの引数オブジェクト
     * @return RPCサービスの応答オブジェクト
     */
    @WebMethod
    GatewayModel submit(@WebParam(name = "request") GatewayModel request);
}
