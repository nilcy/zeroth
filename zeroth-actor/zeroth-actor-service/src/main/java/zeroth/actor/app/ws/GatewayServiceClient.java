// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.app.ws;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import javax.inject.Inject;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceException;
import org.slf4j.Logger;
import zeroth.actor.ApplicationBusinessException;
import zeroth.actor.app.ws.gateway.GatewayModel;
import zeroth.actor.app.ws.gateway.GatewayService;
/**
 * Gateway service client.
 * @author nilcy
 */
public final class GatewayServiceClient {
    /** Logger. */
    @Inject
    private Logger log;
    /** コンストラクタ */
    private GatewayServiceClient() {
        super();
    }
    /**
     * Submit SOAP method.
     * @param <T> application model type
     * @param aSoapRequest SOAP request
     * @return SOAP response
     * @throws ApplicationBusinessException MalformedURLException or
     *             WebServiceException
     */
    @SuppressWarnings("unchecked")
    public <T> T submit(final GatewayModel aSoapRequest) throws ApplicationBusinessException {
        URL url;
        try {
            url = new URL("http://localhost:8080/ReferenceService/CalcService?wsdl");
            final QName serviceName = new QName("http://kuzumeji.com/soap/", "ReferenceService");
            final Service service = Service.create(url, serviceName);
            this.log.debug(service.getWSDLDocumentLocation().toString());
            final GatewayService port = service.getPort(GatewayService.class);
            final Map<String, Object> context = ((BindingProvider) port).getRequestContext();
            this.log.debug(context.entrySet().toString());
            final GatewayModel returnedValue = port.submit(aSoapRequest);
            return (T) returnedValue.getBody();
        } catch (final MalformedURLException e) {
            this.log.warn(e.getLocalizedMessage(), e);
            throw new ApplicationBusinessException(e.getLocalizedMessage());
        } catch (final WebServiceException e) {
            this.log.warn(e.getLocalizedMessage(), e);
            throw new ApplicationBusinessException(e.getLocalizedMessage());
        }
    }
}
