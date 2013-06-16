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
 * Calculator response.
 * @author nilcy
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CalcResponse", propOrder = { "answer" })
public final class CalcResponse {
    /** Answer. */
    @XmlElement(name = "answer", required = true)
    private long answer;
    /** コンストラクタ */
    public CalcResponse() {
        super();
    }
    /**
     * {@link #answer}.
     * @return {@link #answer}
     */
    public long getAnswer() {
        return this.answer;
    }
    /**
     * {@link #answer}.
     * @param aAnswer {@link #answer}
     */
    public void setAnswer(final long aAnswer) {
        this.answer = aAnswer;
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
