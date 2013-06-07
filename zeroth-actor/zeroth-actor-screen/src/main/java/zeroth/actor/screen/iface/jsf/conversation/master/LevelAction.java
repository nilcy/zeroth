// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.screen.iface.jsf.conversation.master;
import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import com.kuzumeji.entity.actor.Level;
import zeroth.actor.screen.iface.jsf.AbstractActionImpl;
import zeroth.framework.enterprise.app.SimpleRepositoryService;
import zeroth.framework.enterprise.app.actor.LevelServiceLocal;
/**
 * Level action.
 * @author nilcy
 */
@Named(value = "levelAction")
@ConversationScoped
public class LevelAction extends AbstractActionImpl<Level> {
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
    public SimpleRepositoryService<Level> getService() {
        return this.service;
    }
}
