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
 * ゲートウェイサービスの集約オブジェクト
 * @author nilcy
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GatewayModel", propOrder = { "header", "status", "body" })
public final class GatewayModel {
    /** ゲートウェイサービスのヘッダ情報 */
    @XmlElement(name = "header", required = true)
    private GatewayHeader header;
    /** ゲートウェイサービスのステータス情報 */
    @XmlElement(name = "status", required = false)
    private GatewayStatus status;
    /** ゲートウェイサービスのボディ情報(JSON形式) */
    @XmlElement(name = "body", required = false)
    private String body;
    /** コンストラクタ */
    public GatewayModel() {
    }
    /**
     * {@link #header} の取得
     * @return {@link #header}
     */
    public GatewayHeader getHeader() {
        return header;
    }
    /**
     * {@link #header} の設定
     * @param header {@link #header}
     */
    public void setHeader(final GatewayHeader header) {
        this.header = header;
    }
    /**
     * {@link #status} の取得
     * @return {@link #status}
     */
    public GatewayStatus getStatus() {
        return status;
    }
    /**
     * {@link #status} の設定
     * @param status {@link #status}
     */
    public void setStatus(final GatewayStatus status) {
        this.status = status;
    }
    /**
     * {@link #body} の取得
     * @return {@link #body}
     */
    public String getBody() {
        return body;
    }
    /**
     * {@link #body} の設定
     * @param body {@link #body}
     */
    public void setBody(final String body) {
        this.body = body;
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
