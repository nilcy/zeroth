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
 * Gateway status.
 * @author nilcy
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GatewayFault", propOrder = { "code", "reason", "message" })
public final class GatewayStatus {
    /** Associated status code. */
    @XmlElement(name = "code", required = false)
    private Integer code;
    /** Reason phrase. */
    @XmlElement(name = "reason", required = false)
    private String reason;
    /** Status message. */
    @XmlElement(name = "message", required = false)
    private String message;
    /** Constructor. */
    public GatewayStatus() {
        super();
    }
    /**
     * Get {@link #code}.
     * @return {@link #code}
     */
    public Integer getCode() {
        return this.code;
    }
    /**
     * Set {@link #code}.
     * @param aCode {@link #code}
     */
    public void setCode(final Integer aCode) {
        this.code = aCode;
    }
    /**
     * Get {@link #reason}.
     * @return {@link #reason}
     */
    public String getReason() {
        return this.reason;
    }
    /**
     * Set {@link #reason}.
     * @param aReason {@link #reason}
     */
    public void setReason(final String aReason) {
        this.reason = aReason;
    }
    /**
     * Get {@link #message}.
     * @return {@link #message}
     */
    public String getMessage() {
        return this.message;
    }
    /**
     * Set {@link #message}.
     * @param aMessage {@link #message}
     */
    public void setMessage(final String aMessage) {
        this.message = aMessage;
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
