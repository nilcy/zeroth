// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.app.ws;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zeroth.framework.standard.app.GatewayModel;
/**
 * SOAP client.
 * @author nilcy
 */
public final class SoapClient {
    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(SoapClient.class);
    /** コンストラクタ */
    private SoapClient() {
        super();
    }
    /**
     * Submit SOAP method.
     * @param <T> service endpoint interface
     * @param aSoapRequest SOAP request
     * @param aServiceInterface Service endpoint interface
     * @return SOAP response
     * @throws MalformedURLException Thrown to indicate that a malformed URL has
     *             occurred. Either no legal protocol could be found in a
     *             specification string or the string could not be parsed.
     */
    public static <T> T submit(final GatewayModel aSoapRequest, final Class<T> aServiceInterface)
        throws MalformedURLException {
        final URL url = new URL(aSoapRequest.getHeader().getWsdlLocation());
        final QName serviceName = new QName(aSoapRequest.getHeader().getNamespaceURI(),
            aSoapRequest.getHeader().getLocalPart());
        final Service service = Service.create(url, serviceName);
        LOG.debug(service.getWSDLDocumentLocation().toString());
        // final T port = service.getPort(aServiceInterface);
        // return port.sayHello("nilcy");
        return null;
    }
}
