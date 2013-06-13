// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.app;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import net.sf.json.JSONObject;
import zeroth.framework.standard.shared.StandardRuntimeException;
/**
 * Gateway model utility.
 * @author nilcy
 */
public final class GatewayUtil {
    /** Constructor. */
    private GatewayUtil() {
        super();
    }
    /**
     * Encode body.
     * @param <T> body type
     * @param aBody body
     * @return encoded body
     */
    public static <T> String encode(final T aBody) {
        return JSONObject.fromObject(aBody).toString();
    }
    /**
     * Decode body.
     * @param <T> body type
     * @param aBody body
     * @param aBeanClass bean class
     * @return decoded body
     */
    public static <T> T decode(final String aBody, final Class<T> aBeanClass) {
        final JSONObject jsonObject = JSONObject.fromObject(aBody);
        return (T) JSONObject.toBean(jsonObject, aBeanClass);
    }
    /**
     * Marshal body.
     * @param aModel model
     * @return marshal body
     */
    public static String marshal(final GatewayModel aModel) {
        try {
            final JAXBContext context = JAXBContext.newInstance(GatewayModel.class);
            final JAXBElement<GatewayModel> element = new JAXBElement<>(new QName("submit"),
                GatewayModel.class, aModel);
            final Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            // marshaller.marshal(element, System.out);
            final StringWriter writer = new StringWriter();
            marshaller.marshal(element, writer);
            return writer.toString();
        } catch (final JAXBException e) {
            throw new StandardRuntimeException(e);
        }
    }
}
