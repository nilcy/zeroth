// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.app;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
/**
 * Gateway model.
 * @author nilcy
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GatewayModel", propOrder = { "header", "status", "body" })
public final class GatewayModel {
    /** Gateway header. */
    @XmlElement(name = "header", required = true)
    private GatewayHeader header;
    /** Gateway status. */
    @XmlElement(name = "status", required = false)
    private GatewayStatus status;
    /** Gateway body. required JSON encoded. */
    @XmlElement(name = "body", required = false)
    private String body;
    /** Constructor. */
    public GatewayModel() {
        super();
    }
    /**
     * Get {@link #header}.
     * @return {@link #header}
     */
    public GatewayHeader getHeader() {
        return this.header;
    }
    /**
     * Set {@link #header}.
     * @param aHeader {@link #header}
     */
    public void setHeader(final GatewayHeader aHeader) {
        this.header = aHeader;
    }
    /**
     * Get {@link #status}.
     * @return {@link #status}
     */
    public GatewayStatus getStatus() {
        return this.status;
    }
    /**
     * Set {@link #status}.
     * @param astatus {@link #status}
     */
    public void setStatus(final GatewayStatus astatus) {
        this.status = astatus;
    }
    /**
     * Get {@link #body}.
     * @return {@link #body}
     */
    public String getBody() {
        return this.body;
    }
    /**
     * Set {@link #body}.
     * @param aBody {@link #body}
     */
    public void setBody(final String aBody) {
        this.body = aBody;
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
