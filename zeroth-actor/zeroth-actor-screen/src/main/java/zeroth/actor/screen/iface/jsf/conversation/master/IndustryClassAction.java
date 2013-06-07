// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.screen.iface.jsf.conversation.master;
import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import com.kuzumeji.entity.misc.IndustryClass;
import zeroth.actor.screen.iface.jsf.AbstractActionImpl;
import zeroth.framework.enterprise.app.SimpleRepositoryService;
import zeroth.framework.enterprise.app.misc.IndustryClassServiceLocal;
/**
 * Industry classification action.
 * @author nilcy
 */
@Named(value = "industryClassAction")
@ConversationScoped
public class IndustryClassAction extends AbstractActionImpl<IndustryClass> {
    /** S/N. */
    private static final long serialVersionUID = 7243039551620767571L;
    /** industry classification service Local-I/F. */
    @EJB
    private IndustryClassServiceLocal service;
    /** Constructor. */
    public IndustryClassAction() {
        super();
    }
    @Override
    public SimpleRepositoryService<IndustryClass> getService() {
        return this.service;
    }
}
