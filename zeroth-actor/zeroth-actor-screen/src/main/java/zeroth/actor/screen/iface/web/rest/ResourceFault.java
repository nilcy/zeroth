// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.screen.iface.web.rest;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * Resource fault.
 * @author nilcy
 */
@XmlRootElement
public class ResourceFault {
    /** Fault code. */
    private String code;
    /** Fault message. */
    private String message;
    /** コンストラクタ */
    public ResourceFault() {
        super();
    }
    /**
     * コンストラクタ
     * @param aCode fault code
     * @param aMessage fault message
     */
    public ResourceFault(final String aCode, final String aMessage) {
        super();
        this.code = aCode;
        this.message = aMessage;
    }
    /**
     * {@link #code}.
     * @return {@link #code}
     */
    public String getCode() {
        return this.code;
    }
    /**
     * {@link #code}.
     * @param aCode {@link #code}
     */
    public void setCode(final String aCode) {
        this.code = aCode;
    }
    /**
     * {@link #message}.
     * @return {@link #message}
     */
    public String getMessage() {
        return this.message;
    }
    /**
     * {@link #message}.
     * @param aMessage {@link #message}
     */
    public void setMessage(final String aMessage) {
        this.message = aMessage;
    }
}
