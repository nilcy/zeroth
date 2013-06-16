// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.screen.iface.jsf.conversation.master;
import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import zeroth.actor.service.app.actor.LevelApplication;
import zeroth.actor.service.domain.Level;
import zeroth.framework.enterprise.app.SimpleRepositoryApplication;
import zeroth.framework.screen.iface.jsf.AbstractActionImpl;
/**
 * Level action.
 * @author nilcy
 */
@Named(value = "levelAction")
@ConversationScoped
public class LevelAction extends AbstractActionImpl<Level, Long, Level> {
    /** 製品番号 */
    private static final long serialVersionUID = 944558410807492976L;
    /** level service Local-I/F. */
    @EJB
    private LevelApplication service;
    /** コンストラクタ */
    public LevelAction() {
        super();
    }
    @Override
    public SimpleRepositoryApplication<Level, Long, Level> getService() {
        return service;
    }
}
