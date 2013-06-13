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
 * Gateway header.
 * @author nilcy
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GatewayHeader", propOrder = { "wsdlLocation", "namespaceURI", "localPart",
    "endpoint", "operation", "parameter" })
public final class GatewayHeader {
    /** WSDL document location. */
    @XmlElement(name = "wsdlLocation", required = true)
    private String wsdlLocation;
    /** Namespace URI of service name. */
    @XmlElement(name = "namespaceURI", required = true)
    private String namespaceURI;
    /** Local part of service name. */
    @XmlElement(name = "localPart", required = true)
    private String localPart;
    /** Endpoint interface. */
    @XmlElement(name = "endpoint", required = true)
    private String endpoint;
    /** Operation name. */
    @XmlElement(name = "operation", required = true)
    private String operation;
    /** Parameter class. */
    @XmlElement(name = "parameter", required = true)
    private String parameter;
    /** Constructor. */
    public GatewayHeader() {
        super();
    }
    /**
     * Get {@link #wsdlLocation}.
     * @return {@link #wsdlLocation}
     */
    public String getWsdlLocation() {
        return this.wsdlLocation;
    }
    /**
     * Set {@link #wsdlLocation}.
     * @param aWsdlLocation {@link #wsdlLocation}
     */
    public void setWsdlLocation(final String aWsdlLocation) {
        this.wsdlLocation = aWsdlLocation;
    }
    /**
     * Get {@link #namespaceURI}.
     * @return {@link #namespaceURI}
     */
    public String getNamespaceURI() {
        return this.namespaceURI;
    }
    /**
     * Set {@link #namespaceURI}.
     * @param aNamespaceURI {@link #namespaceURI}
     */
    public void setNamespaceURI(final String aNamespaceURI) {
        this.namespaceURI = aNamespaceURI;
    }
    /**
     * Get {@link #localPart}.
     * @return {@link #localPart}
     */
    public String getLocalPart() {
        return this.localPart;
    }
    /**
     * Set {@link #localPart}.
     * @param aLocalPart {@link #localPart}
     */
    public void setLocalPart(final String aLocalPart) {
        this.localPart = aLocalPart;
    }
    /**
     * Get {@link #operation}.
     * @return {@link #operation}
     */
    public String getOperation() {
        return this.operation;
    }
    /**
     * Get {@link #endpoint}.
     * @return {@link #endpoint}
     */
    public String getEndpoint() {
        return this.endpoint;
    }
    /**
     * Set {@link #endpoint}.
     * @param aEndpoint {@link #endpoint}
     */
    public void setEndpoint(final String aEndpoint) {
        this.endpoint = aEndpoint;
    }
    /**
     * Set {@link #operation}.
     * @param aOperationName {@link #operation}
     */
    public void setOperation(final String aOperationName) {
        this.operation = aOperationName;
    }
    /**
     * Get {@link #parameter}.
     * @return {@link #parameter}
     */
    public String getParameter() {
        return this.parameter;
    }
    /**
     * Set {@link #parameter}.
     * @param aParameter {@link #parameter}
     */
    public void setParameter(final String aParameter) {
        this.parameter = aParameter;
    }
    /**
     * Build toString.
     * @return String result
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE, true);
    }
}
