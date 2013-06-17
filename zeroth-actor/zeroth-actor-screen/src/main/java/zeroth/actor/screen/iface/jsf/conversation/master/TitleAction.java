// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.screen.iface.jsf.conversation.master;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import zeroth.actor.screen.app.ApplicationAnnotation.TitleApplicationCDI;
import zeroth.actor.service.app.actor.TitleApplication;
import zeroth.actor.service.domain.Title;
import zeroth.framework.enterprise.app.SimpleRepositoryApplication;
import zeroth.framework.screen.iface.jsf.AbstractActionImpl;
import zeroth.framework.standard.shared.FilterFactory;
import zeroth.framework.standard.shared.SimpleFilter;
/**
 * 職名アクション
 * @author nilcy
 */
@Named(value = "titleAction")
@ConversationScoped
public class TitleAction extends AbstractActionImpl<Title, Long, SimpleFilter> {
    /** 製品番号 */
    private static final long serialVersionUID = -1742312463790367432L;
    /** 職名アプリケーションI/F */
    @Inject
    @TitleApplicationCDI
    private TitleApplication titleApplication;
    /** コンストラクタ */
    public TitleAction() {
    }
    /** {@inheritDoc} */
    @Override
    public SimpleRepositoryApplication<Title, Long, SimpleFilter> getApplication() {
        return titleApplication;
    }
    /** {@inheritDoc} */
    @Override
    protected SimpleFilter createFilter() {
        return FilterFactory.createSimpleFilter();
    }
}
