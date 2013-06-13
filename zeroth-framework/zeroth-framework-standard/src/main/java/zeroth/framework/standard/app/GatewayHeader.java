// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.app;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
/**
 * ゲートウェイサービスのヘッダオブジェクト
 * @author nilcy
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GatewayHeader", propOrder = { "wsdlLocation", "namespaceURI", "localPart",
    "endpoint", "operation", "parameter" })
public final class GatewayHeader {
    /** WSDLロケーション */
    @XmlElement(name = "wsdlLocation", required = true)
    private String wsdlLocation;
    /** URIネームスペース */
    @XmlElement(name = "namespaceURI", required = true)
    private String namespaceURI;
    /** ローカルパート */
    @XmlElement(name = "localPart", required = true)
    private String localPart;
    /** エンドポイントI/F */
    @XmlElement(name = "endpoint", required = true)
    private String endpoint;
    /** オペレーション名 */
    @XmlElement(name = "operation", required = true)
    private String operation;
    /** パラメータクラス名 */
    @XmlElement(name = "parameter", required = true)
    private String parameter;
    /** コンストラクタ */
    public GatewayHeader() {
    }
    /**
     * {@link #wsdlLocation} の取得
     * @return {@link #wsdlLocation}
     */
    public String getWsdlLocation() {
        return wsdlLocation;
    }
    /**
     * {@link #wsdlLocation} の設定
     * @param wsdlLocation {@link #wsdlLocation}
     */
    public void setWsdlLocation(final String wsdlLocation) {
        this.wsdlLocation = wsdlLocation;
    }
    /**
     * {@link #namespaceURI} の取得
     * @return {@link #namespaceURI}
     */
    public String getNamespaceURI() {
        return namespaceURI;
    }
    /**
     * {@link #namespaceURI} の設定
     * @param namespaceURI {@link #namespaceURI}
     */
    public void setNamespaceURI(final String namespaceURI) {
        this.namespaceURI = namespaceURI;
    }
    /**
     * {@link #localPart} の取得
     * @return {@link #localPart}
     */
    public String getLocalPart() {
        return localPart;
    }
    /**
     * {@link #localPart} の設定
     * @param localPart {@link #localPart}
     */
    public void setLocalPart(final String localPart) {
        this.localPart = localPart;
    }
    /**
     * {@link #operation} の取得
     * @return {@link #operation}
     */
    public String getOperation() {
        return operation;
    }
    /**
     * {@link #operation} の設定
     * @param operationName {@link #operation}
     */
    public void setOperation(final String operationName) {
        operation = operationName;
    }
    /**
     * {@link #endpoint} の設定
     * @return {@link #endpoint}
     */
    public String getEndpoint() {
        return endpoint;
    }
    /**
     * {@link #endpoint} の取得
     * @param endpoint {@link #endpoint}
     */
    public void setEndpoint(final String endpoint) {
        this.endpoint = endpoint;
    }
    /**
     * {@link #parameter} の取得
     * @return {@link #parameter}
     */
    public String getParameter() {
        return parameter;
    }
    /**
     * {@link #parameter} の設定
     * @param parameter {@link #parameter}
     */
    public void setParameter(final String parameter) {
        this.parameter = parameter;
    }
    /**
     * 文字列表現の作成
     * @return 文字列表現
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE, true);
    }
}
