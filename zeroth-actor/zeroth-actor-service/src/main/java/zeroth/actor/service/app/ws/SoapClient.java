// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.app.ws;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import zeroth.framework.standard.app.GatewayModel;
/**
 * SOAP client.
 * @author nilcy
 */
public final class SoapClient {
    /** ロガー */
    private static final Logger LOG = Logger.getGlobal();
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
        LOG.fine(service.getWSDLDocumentLocation().toString());
        // final T port = service.getPort(aServiceInterface);
        // return port.sayHello("nilcy");
        return null;
    }
}
