// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.app.ws.gateway;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.core.Response.Status;
import org.slf4j.Logger;
import zeroth.framework.service.app.GatewayFactory;
import zeroth.framework.service.app.GatewayService;
import zeroth.framework.standard.app.GatewayHeader;
import zeroth.framework.standard.app.GatewayModel;
import zeroth.framework.standard.app.GatewayUtil;
/**
 * Gateway service.
 * @author nilcy
 */
@Stateless
@WebService(portName = "GatewayPort", serviceName = "GatewayService", name = "Gateway", targetNamespace = "http://kuzumeji.com/ws/gateway", endpointInterface = "zeroth.actor.app.ws.gateway.GatewayService")
public class GatewayServiceImpl implements GatewayService {
    /** Logger. */
    @Inject
    private Logger log;
    /** コンストラクタ */
    public GatewayServiceImpl() {
        super();
    }
    /** {@inheritDoc} */
    @Override
    @WebMethod
    public GatewayModel submit(@WebParam(name = "request") final GatewayModel aRequest) {
        try {
            final GatewayHeader header = aRequest.getHeader();
            final Class<?> interfaceClass = Class.forName(header.getEndpoint());
            final Class<?> parameterClass = Class.forName(header.getParameter());
            final Object proxy = GatewayUtil.getProxy(header.getWsdlLocation(),
                header.getNamespaceURI(), header.getLocalPart(), interfaceClass);
            final Method method = interfaceClass.getMethod(header.getOperation(),
                new Class[] { parameterClass });
            final Object ret = method.invoke(proxy,
                new Object[] { GatewayUtil.decode(aRequest.getBody(), parameterClass) });
            aRequest.setBody(GatewayUtil.encode(ret));
            aRequest.setStatus(GatewayFactory.createStatus(Status.OK));
            // return aRequest;
        } catch (final ClassNotFoundException e) {
            aRequest.setStatus(GatewayFactory.createStatus(Status.BAD_REQUEST,
                e.getLocalizedMessage()));
        } catch (final SecurityException e) {
            aRequest.setStatus(GatewayFactory.createStatus(Status.FORBIDDEN,
                e.getLocalizedMessage()));
        } catch (final NoSuchMethodException e) {
            aRequest.setStatus(GatewayFactory.createStatus(Status.BAD_REQUEST,
                e.getLocalizedMessage()));
        } catch (final IllegalArgumentException e) {
            aRequest.setStatus(GatewayFactory.createStatus(Status.BAD_REQUEST,
                e.getLocalizedMessage()));
        } catch (final IllegalAccessException e) {
            aRequest.setStatus(GatewayFactory.createStatus(Status.BAD_REQUEST,
                e.getLocalizedMessage()));
        } catch (final InvocationTargetException e) {
            aRequest.setStatus(GatewayFactory.createStatus(Status.INTERNAL_SERVER_ERROR,
                e.getLocalizedMessage()));
        }
        return aRequest;
    }
}
