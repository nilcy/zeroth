// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.screen.iface.jsf.conversation.master;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import zeroth.actor.screen.app.ApplicationAnnotation.LevelApplicationCDI;
import zeroth.actor.service.app.actor.LevelApplication;
import zeroth.actor.service.domain.Level;
import zeroth.framework.enterprise.app.SimpleRepositoryApplication;
import zeroth.framework.screen.iface.jsf.AbstractActionImpl;
import zeroth.framework.standard.shared.FilterFactory;
import zeroth.framework.standard.shared.SimpleFilter;
/**
 * 職級アクション
 * @author nilcy
 */
@Named(value = "levelAction")
@ConversationScoped
public class LevelAction extends AbstractActionImpl<Level, Long, SimpleFilter> {
    /** 製品番号 */
    private static final long serialVersionUID = 944558410807492976L;
    /** 職級アプリケーションI/F */
    @Inject
    @LevelApplicationCDI
    private LevelApplication levelApplication;
    /** コンストラクタ */
    public LevelAction() {
    }
    /** {@inheritDoc} */
    @Override
    public SimpleRepositoryApplication<Level, Long, SimpleFilter> getApplication() {
        return levelApplication;
    }
    /** {@inheritDoc} */
    @Override
    protected SimpleFilter createFilter() {
        return FilterFactory.createSimpleFilter();
    }
}
