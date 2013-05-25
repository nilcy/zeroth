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
     * @param aSession メールセッション
     */
    void setup(final Session aSession);
    /**
     * メール送信
     * @param aFrom FROMアドレス
     * @param aTo TOアドレス
     * @param aSubject メール件名
     * @param aObjectBody メール本文
     * @param aContentType メール本文のコンテンツタイプ
     * @throws EnterpriseException 指定アドレスの不正、またはメール送信の失敗
     */
    void send(final String aFrom, final String aTo, final String aSubject,
        final Object aObjectBody, final String aContentType) throws EnterpriseException;
    /**
     * テキストメール送信
     * @param aFrom FROMアドレス
     * @param aTo TOアドレス
     * @param aSubject メール件名
     * @param aTextBody メール本文 (text/plain)
     * @throws EnterpriseException 指定アドレスの不正、またはメール送信の失敗
     */
    void send(final String aFrom, final String aTo, final String aSubject, final String aTextBody)
        throws EnterpriseException;
    /**
     * マルチパートメール送信
     * @param aFrom FROMアドレス
     * @param aTo TOアドレス
     * @param aSubject メール件名
     * @param aMultipartBody メール本文 (マルチパート)
     * @throws EnterpriseException 指定アドレスの不正、またはメール送信の失敗
     */
    void send(final String aFrom, final String aTo, final String aSubject,
        final Multipart aMultipartBody) throws EnterpriseException;
}
