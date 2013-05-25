// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.infra.messaging;
import javax.ejb.EJB;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.mail.Session;
/**
 * メールサービスのファクトリ
 * @author nilcy
 */
public final class MailServiceFactory {
    /** 基礎メールセッション */
    @Inject
    @PrimaryMailSession
    private Session session;
    /** メールサービスI/F */
    @EJB
    public MailService mailService;
    /** コンストラクタ */
    public MailServiceFactory() {
    }
    /**
     * メールサービスの作成
     * @return メールサービス
     */
    @Produces
    public MailService createMailService() {
        this.mailService.setup(this.session);
        return this.mailService;
    }
}
