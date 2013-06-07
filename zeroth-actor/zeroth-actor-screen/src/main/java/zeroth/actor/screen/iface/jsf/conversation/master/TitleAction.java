// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.screen.iface.jsf.conversation.master;
import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import com.kuzumeji.entity.actor.Title;
import zeroth.actor.screen.iface.jsf.AbstractActionImpl;
import zeroth.framework.enterprise.app.SimpleRepositoryService;
import zeroth.framework.enterprise.app.actor.TitleServiceLocal;
/**
 * Title action.
 * @author nilcy
 */
@Named(value = "titleAction")
@ConversationScoped
public class TitleAction extends AbstractActionImpl<Title> {
    /** S/N. */
    private static final long serialVersionUID = -1742312463790367432L;
    /** industry classification service Local-I/F. */
    @EJB
    private TitleServiceLocal service;
    /** Constructor. */
    public TitleAction() {
        super();
    }
    @Override
    public SimpleRepositoryService<Title> getService() {
        return this.service;
    }
}
