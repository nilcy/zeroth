// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.app.ws.calc;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
/**
 * Calculator request.
 * @author nilcy
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CalcRequest", propOrder = { "param1", "param2" })
public final class CalcRequest {
    /** 1st parameter. */
    @XmlElement(name = "param1", required = true)
    private long param1;
    /** 2nd parameter. */
    @XmlElement(name = "param2", required = true)
    private long param2;
    /** コンストラクタ */
    public CalcRequest() {
        super();
    }
    /**
     * {@link #param1}.
     * @return {@link #param1}
     */
    public long getParam1() {
        return this.param1;
    }
    /**
     * {@link #param1}.
     * @param aParam1 {@link #param1}
     */
    public void setParam1(final long aParam1) {
        this.param1 = aParam1;
    }
    /**
     * {@link #param2}.
     * @return {@link #param2}
     */
    public long getParam2() {
        return this.param2;
    }
    /**
     * {@link #param2}.
     * @param aParam2 {@link #param2}
     */
    public void setParam2(final long aParam2) {
        this.param2 = aParam2;
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
