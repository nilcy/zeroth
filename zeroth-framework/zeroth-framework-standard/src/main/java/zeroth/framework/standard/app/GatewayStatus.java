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
 * ゲートウェイサービスのステータスオブジェクト
 * @author nilcy
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GatewayFault", propOrder = { "code", "reason", "message" })
public final class GatewayStatus {
    /** ステータスコード(HTTP標準) */
    @XmlElement(name = "code", required = false)
    private Integer code;
    /** ステータス概説(HTTP標準ベース) */
    @XmlElement(name = "reason", required = false)
    private String reason;
    /** ステータスメッセージ(自由形式) */
    @XmlElement(name = "message", required = false)
    private String message;
    /** コンストラクタ */
    public GatewayStatus() {
    }
    /**
     * {@link #code} の取得
     * @return {@link #code}
     */
    public Integer getCode() {
        return code;
    }
    /**
     * {@link #code} の設定
     * @param code {@link #code}
     */
    public void setCode(final Integer code) {
        this.code = code;
    }
    /**
     * {@link #reason} の取得
     * @return {@link #reason}
     */
    public String getReason() {
        return reason;
    }
    /**
     * {@link #reason} の設定
     * @param reason {@link #reason}
     */
    public void setReason(final String reason) {
        this.reason = reason;
    }
    /**
     * {@link #message} の取得
     * @return {@link #message}
     */
    public String getMessage() {
        return message;
    }
    /**
     * {@link #message} の設定
     * @param message {@link #message}
     */
    public void setMessage(final String message) {
        this.message = message;
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
