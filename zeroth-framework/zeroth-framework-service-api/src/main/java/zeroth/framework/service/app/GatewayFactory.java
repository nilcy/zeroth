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
 * ゲートウェイオブジェクトのファクトリ
 * @author nilcy
 */
public final class GatewayFactory {
    /** 非公開コンストラクタ */
    private GatewayFactory() {
    }
    /**
     * {@link GatewayHeader} の作成
     * @param wsdlLocation {@link GatewayHeader#setWsdlLocation(String)}
     * @param namespaceURI {@link GatewayHeader#setNamespaceURI(String)}
     * @param localPart {@link GatewayHeader#setLocalPart(String)}
     * @param endpoint {@link GatewayHeader#setEndpoint(String)}
     * @param operation {@link GatewayHeader#setOperation(String)}
     * @param parameter {@link GatewayHeader#setParameter(String)}
     * @return {@link GatewayHeader}
     */
    public static GatewayHeader createHeader(final String wsdlLocation,
        final String namespaceURI, final String localPart, final String endpoint,
        final String operation, final String parameter) {
        final GatewayHeader header = new GatewayHeader();
        header.setWsdlLocation(wsdlLocation);
        header.setNamespaceURI(namespaceURI);
        header.setLocalPart(localPart);
        header.setEndpoint(endpoint);
        header.setOperation(operation);
        header.setParameter(parameter);
        return header;
    }
    /**
     * {@link GatewayStatus} の作成
     * @param httpStatus {@link Status}
     * @return {@link GatewayStatus}
     */
    public static GatewayStatus createStatus(final Status httpStatus) {
        final GatewayStatus status = new GatewayStatus();
        status.setCode(Integer.valueOf(httpStatus.getStatusCode()));
        status.setReason(httpStatus.toString());
        status.setMessage(StringUtils.EMPTY);
        return status;
    }
    /**
     * {@link GatewayStatus}　の作成
     * @param httpStatus {@link Status}
     * @param message {@link GatewayStatus#setMessage(String)}
     * @return {@link GatewayStatus}
     */
    public static GatewayStatus createStatus(final Status httpStatus, final String message) {
        final GatewayStatus status = createStatus(httpStatus);
        status.setMessage(message);
        return status;
    }
    /**
     * {@link GatewayModel}　の作成
     * @return {@link GatewayModel}
     */
    public static GatewayModel create() {
        final GatewayModel model = new GatewayModel();
        model.setHeader(new GatewayHeader());
        model.setStatus(new GatewayStatus());
        return model;
    }
    /**
     * {@link GatewayModel} の作成
     * @param <T> ボディオブジェクト型
     * @param body ボディオブジェクト
     * @return {@link GatewayModel}
     */
    public static <T> GatewayModel create(final T body) {
        final GatewayModel model = create();
        model.setBody(GatewayUtil.encode(body));
        return model;
    }
}
