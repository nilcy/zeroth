// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.service.app;
import javax.ws.rs.core.Response.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zeroth.framework.standard.app.GatewayHeader;
import zeroth.framework.standard.app.GatewayModel;
import zeroth.framework.standard.app.WsUtil;
import zeroth.framework.standard.shared.StandardException;
/**
 * Gateway WS client.
 * @author nilcy
 */
public final class GatewayClient {
    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(GatewayClient.class);
    /** Constructor. */
    private GatewayClient() {
        super();
    }
    /**
     * Submit.
     * @param <T> body type
     * @param aHeader {@link GatewayModel#setHeader(GatewayHeader)}
     * @param aBody {@link GatewayModel#setBody(String)}
     * @return {@link GatewayModel}
     * @throws StandardException returned NOT {@link Status#OK}
     */
    public static <T> GatewayModel submit(final GatewayHeader aHeader, final T aBody)
        throws StandardException {
        final GatewayService gateway = WsUtil.getProxy(GatewayService.class);
        final GatewayModel request = GatewayFactory.create(aBody);
        request.setHeader(aHeader);
        final GatewayModel returnModel = gateway.submit(request);
        if (returnModel.getStatus().getCode().intValue() != Status.OK.getStatusCode()) {
            LOG.warn("returnModel is {}", returnModel);
            throw new StandardException("", returnModel.getStatus().getMessage());
        }
        return returnModel;
    }
}
