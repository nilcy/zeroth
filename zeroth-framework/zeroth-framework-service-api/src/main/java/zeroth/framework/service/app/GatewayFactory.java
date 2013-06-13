// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.service.app;
import javax.ws.rs.core.Response.Status;
import org.apache.commons.lang3.StringUtils;
import zeroth.framework.standard.app.GatewayHeader;
import zeroth.framework.standard.app.GatewayModel;
import zeroth.framework.standard.app.GatewayStatus;
import zeroth.framework.standard.app.GatewayUtil;
/**
 * Gateway model factory.
 * @author nilcy
 */
public final class GatewayFactory {
    /** Constructor. */
    private GatewayFactory() {
        super();
    }
    /**
     * Create {@link GatewayHeader}.
     * @param aWsdlLocation {@link GatewayHeader#setWsdlLocation(String)}
     * @param aNamespaceURI {@link GatewayHeader#setNamespaceURI(String)}
     * @param aLocalPart {@link GatewayHeader#setLocalPart(String)}
     * @param aEndpoint {@link GatewayHeader#setEndpoint(String)}
     * @param aOperation {@link GatewayHeader#setOperation(String)}
     * @param aParameter {@link GatewayHeader#setParameter(String)}
     * @return {@link GatewayHeader}
     */
    public static GatewayHeader createHeader(final String aWsdlLocation,
        final String aNamespaceURI, final String aLocalPart, final String aEndpoint,
        final String aOperation, final String aParameter) {
        final GatewayHeader header = new GatewayHeader();
        header.setWsdlLocation(aWsdlLocation);
        header.setNamespaceURI(aNamespaceURI);
        header.setLocalPart(aLocalPart);
        header.setEndpoint(aEndpoint);
        header.setOperation(aOperation);
        header.setParameter(aParameter);
        return header;
    }
    /**
     * Create {@link GatewayStatus}.
     * @param aStatus {@link Status}
     * @return {@link GatewayStatus}
     */
    public static GatewayStatus createStatus(final Status aStatus) {
        final GatewayStatus status = new GatewayStatus();
        status.setCode(Integer.valueOf(aStatus.getStatusCode()));
        status.setReason(aStatus.toString());
        status.setMessage(StringUtils.EMPTY);
        return status;
    }
    /**
     * Create {@link GatewayStatus}.
     * @param aStatus {@link Status}
     * @param aMessage {@link GatewayStatus#setMessage(String)}
     * @return {@link GatewayStatus}
     */
    public static GatewayStatus createStatus(final Status aStatus, final String aMessage) {
        final GatewayStatus status = createStatus(aStatus);
        status.setMessage(aMessage);
        return status;
    }
    /**
     * Create {@link GatewayModel}.
     * @return {@link GatewayModel}
     */
    public static GatewayModel create() {
        final GatewayModel model = new GatewayModel();
        model.setHeader(new GatewayHeader());
        model.setStatus(new GatewayStatus());
        return model;
    }
    /**
     * Create {@link GatewayModel}.
     * @param <T> body type
     * @param aBody body
     * @return {@link GatewayModel}
     */
    public static <T> GatewayModel create(final T aBody) {
        final GatewayModel model = create();
        model.setBody(GatewayUtil.encode(aBody));
        return model;
    }
}
