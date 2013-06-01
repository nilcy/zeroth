// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.infra.messaging;
import javax.ejb.Local;
import javax.mail.Multipart;
import javax.mail.Session;
import zeroth.framework.enterprise.shared.EnterpriseException;
import zeroth.framework.standard.shared.Service;
/**
 * メールサービスI/F
 * @author nilcy
 */
@Local
public interface MailService extends Service {
    /**
     * 初期化
     * @param session メールセッション
     */
    void setup(final Session session);
    /**
     * メール送信
     * @param from FROMアドレス
     * @param to TOアドレス
     * @param subject メール件名
     * @param objectBody メール本文
     * @param contentType メール本文のコンテンツタイプ
     * @throws EnterpriseException 指定アドレスの不正、またはメール送信の失敗
     */
    void send(final String from, final String to, final String subject,
        final Object objectBody, final String contentType) throws EnterpriseException;
    /**
     * テキストメール送信
     * @param from FROMアドレス
     * @param to TOアドレス
     * @param subject メール件名
     * @param textBody メール本文 (text/plain)
     * @throws EnterpriseException 指定アドレスの不正、またはメール送信の失敗
     */
    void send(final String from, final String to, final String subject, final String textBody)
        throws EnterpriseException;
    /**
     * マルチパートメール送信
     * @param from FROMアドレス
     * @param to TOアドレス
     * @param subject メール件名
     * @param multipartBody メール本文 (マルチパート)
     * @throws EnterpriseException 指定アドレスの不正、またはメール送信の失敗
     */
    void send(final String from, final String to, final String subject,
        final Multipart multipartBody) throws EnterpriseException;
}
