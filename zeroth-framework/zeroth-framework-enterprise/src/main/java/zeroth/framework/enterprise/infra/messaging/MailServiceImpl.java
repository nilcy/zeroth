// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.infra.messaging;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.commons.lang3.Validate;
import zeroth.framework.enterprise.shared.EnterpriseException;
/**
 * メールサービスI/F
 * @author nilcy
 */
@Stateless
@Alternative
public class MailServiceImpl implements MailService {
    /** 識別番号 */
    private static final long serialVersionUID = 5415112327668280272L;
    /** メールセッション */
    @Resource(name = "mail/primary")
    private Session session;
    @Override
    public void setup(final Session session) {
        this.session = session;
    }
    @Override
    public void send(final String from, final String to, final String subject,
        final Object objectBody, final String contentType) throws EnterpriseException {
        try {
            final Message message = createMessage(from, to, subject);
            message.setContent(objectBody, contentType);
            send(message);
        } catch (final MessagingException e) {
            throw new EnterpriseException(e);
        }
    }
    @Override
    public void send(final String from, final String to, final String subject, final String textBody)
        throws EnterpriseException {
        try {
            final Message message = createMessage(from, to, subject);
            message.setContent(textBody, "text/plain");
            send(message);
        } catch (final MessagingException e) {
            throw new EnterpriseException(e);
        }
    }
    @Override
    public void send(final String from, final String to, final String subject,
        final Multipart multipartBody) throws EnterpriseException {
        try {
            final Message message = createMessage(from, to, subject);
            message.setContent(multipartBody);
            send(message);
        } catch (final MessagingException e) {
            throw new EnterpriseException(e);
        }
    }
    /**
     * メッセージの作成
     * @param from FROMアドレス
     * @param to TOアドレス
     * @param subject メール件名
     * @return メッセージ
     * @throws EnterpriseException 指定アドレス、メッセージの例外
     */
    private Message createMessage(final String from, final String to, final String subject)
        throws EnterpriseException {
        Validate.notNull(session, "メールセッションはないといけません。");
        try {
            final Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            return message;
        } catch (final AddressException e) {
            throw new EnterpriseException(e);
        } catch (final MessagingException e) {
            throw new EnterpriseException(e);
        }
    }
    /**
     * メール送信
     * @param message メッセージ
     * @throws EnterpriseException メッセージの例外
     */
    private static void send(final Message message) throws EnterpriseException {
        try {
            Transport.send(message);
        } catch (final MessagingException e) {
            throw new EnterpriseException(e);
        }
    }
}
