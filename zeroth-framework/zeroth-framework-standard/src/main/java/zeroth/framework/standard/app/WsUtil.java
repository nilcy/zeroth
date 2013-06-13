// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.app;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import zeroth.framework.standard.shared.StandardRuntimeException;
/**
 * WS utility.
 * @author nilcy
 */
public final class WsUtil {
    /** Logger. */
    private static final Logger LOG = Logger.getGlobal();
    /** Constructor. */
    private WsUtil() {
        super();
    }
    /**
     * Get proxy.
     * @param <T> service endpoint I/F type
     * @param aWsdlLocation WSDL location
     * @param aNamespaceURI namespace URI of service name
     * @param aLocalPart local part of service name
     * @param aInterface service endpoint I/F
     * @return service proxy
     */
    public static <T> T getProxy(final String aWsdlLocation, final String aNamespaceURI,
        final String aLocalPart, final Class<T> aInterface) {
        try {
            final URL wsdlURL = new URL(aWsdlLocation);
            final QName serviceName = new QName(aNamespaceURI, aLocalPart);
            final Service service = Service.create(wsdlURL, serviceName);
            return service.getPort(aInterface);
        } catch (final MalformedURLException e) {
            throw new StandardRuntimeException(e);
        }
    }
    /**
     * Get proxy.
     * @param <T> service endpoint I/F type
     * @param aInterface service endpoint I/F
     * @return service proxy
     */
    public static <T> T getProxy(final Class<T> aInterface) {
        try {
            final String baseName = aInterface.getPackage().getName() + ".soap";
            final ResourceBundle bundle = ResourceBundle.getBundle(baseName);
            final String wsdlLocation = bundle.getString("WsdlLocation");
            final String namespaceURI = bundle.getString("NamespaceURI");
            final String localPart = bundle.getString("LocalPart");
            LOG.info(MessageFormat.format("wsdlLocation={0}, namespaceURI={1}, localPart={2}",
                wsdlLocation, namespaceURI, localPart));
            return getProxy(wsdlLocation, namespaceURI, localPart, aInterface);
        } catch (final MissingResourceException e) {
            throw new StandardRuntimeException(e);
        }
    }
}
