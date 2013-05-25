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
    public void setup(final Session aSession) {
        this.session = aSession;
    }
    @Override
    public void send(final String aFrom, final String aTo, final String aSubject,
        final Object aObjectBody, final String aContentType) throws EnterpriseException {
        try {
            final Message message = createMessage(aFrom, aTo, aSubject);
            message.setContent(aObjectBody, aContentType);
            send(message);
        } catch (final MessagingException e) {
            throw new EnterpriseException(e);
        }
    }
    @Override
    public void send(final String aFrom, final String aTo, final String aSubject,
        final String aTextBody) throws EnterpriseException {
        try {
            final Message message = createMessage(aFrom, aTo, aSubject);
            message.setContent(aTextBody, "text/plain");
            send(message);
        } catch (final MessagingException e) {
            throw new EnterpriseException(e);
        }
    }
    @Override
    public void send(final String aFrom, final String aTo, final String aSubject,
        final Multipart aMultipartBody) throws EnterpriseException {
        try {
            final Message message = createMessage(aFrom, aTo, aSubject);
            message.setContent(aMultipartBody);
            send(message);
        } catch (final MessagingException e) {
            throw new EnterpriseException(e);
        }
    }
    /**
     * メッセージの作成
     * @param aFrom FROMアドレス
     * @param aTo TOアドレス
     * @param aSubject メール件名
     * @return メッセージ
     * @throws EnterpriseException 指定アドレス、メッセージの例外
     */
    private Message createMessage(final String aFrom, final String aTo, final String aSubject)
        throws EnterpriseException {
        Validate.notNull(this.session, "メールセッションはないといけません。");
        try {
            final Message message = new MimeMessage(this.session);
            message.setFrom(new InternetAddress(aFrom));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(aTo));
            message.setSubject(aSubject);
            return message;
        } catch (final AddressException e) {
            throw new EnterpriseException(e);
        } catch (final MessagingException e) {
            throw new EnterpriseException(e);
        }
    }
    /**
     * メール送信
     * @param aMessage メッセージ
     * @throws EnterpriseException メッセージの例外
     */
    private static void send(final Message aMessage) throws EnterpriseException {
        try {
            Transport.send(aMessage);
        } catch (final MessagingException e) {
            throw new EnterpriseException(e);
        }
    }
}
