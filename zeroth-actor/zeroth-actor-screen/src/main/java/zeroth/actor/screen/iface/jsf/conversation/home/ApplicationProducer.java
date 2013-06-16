// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.screen.iface.jsf.conversation.home;
import javax.ejb.EJB;
import javax.enterprise.inject.Produces;
import zeroth.actor.service.app.misc.NewsApplication;
import zeroth.actor.service.domain.misc.News;
import zeroth.framework.enterprise.app.SimpleRepositoryApplication;
import zeroth.framework.standard.shared.SimpleFilter;
/**
 * 拡張データ永続化サービスのファクトリ
 * @author nilcy
 */
public class ApplicationProducer {
    /** お知らせアプリケーションI/F */
    @EJB
    private NewsApplication newsApplication;
    /** コンストラクタ */
    public ApplicationProducer() {
    }
    /**
     * {@link #newsApplication} の取得
     * @return {@link #newsApplication}
     */
    @Produces
    // @NewsApplicationLocal
    public SimpleRepositoryApplication<News, Long, SimpleFilter> createNewsRepositoryApplication() {
        return newsApplication;
    }
}
