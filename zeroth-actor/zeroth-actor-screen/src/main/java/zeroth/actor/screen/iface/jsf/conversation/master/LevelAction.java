// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.screen.iface.jsf.conversation.master;
import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import zeroth.actor.app.actor.LevelServiceLocal;
import zeroth.actor.domain.Level;
import zeroth.framework.enterprise.app.SimpleRepositoryService;
import zeroth.framework.screen.iface.jsf.AbstractActionImpl;
/**
 * Level action.
 * @author nilcy
 */
@Named(value = "levelAction")
@ConversationScoped
public class LevelAction extends AbstractActionImpl<Level, Long, Level> {
    /** S/N. */
    private static final long serialVersionUID = 944558410807492976L;
    /** level service Local-I/F. */
    @EJB
    private LevelServiceLocal service;
    /** Constructor. */
    public LevelAction() {
        super();
    }
    @Override
    public SimpleRepositoryService<Level, Long, Level> getService() {
        return service;
    }
}
