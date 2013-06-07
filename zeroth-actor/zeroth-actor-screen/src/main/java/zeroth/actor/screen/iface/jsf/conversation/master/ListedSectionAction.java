// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.screen.iface.jsf.conversation.master;
import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import com.kuzumeji.entity.misc.ListedSection;
import zeroth.actor.screen.iface.jsf.AbstractActionImpl;
import zeroth.framework.enterprise.app.SimpleRepositoryService;
import zeroth.framework.enterprise.app.misc.ListedSectionServiceLocal;
/**
 * Listed section action.
 * @author nilcy
 */
@Named(value = "listedSectionAction")
@ConversationScoped
public class ListedSectionAction extends AbstractActionImpl<ListedSection> {
    /** S/N. */
    private static final long serialVersionUID = 7243039551620767571L;
    /** listed section service Local-I/F. */
    @EJB
    private ListedSectionServiceLocal service;
    /** Constructor. */
    public ListedSectionAction() {
        super();
    }
    @Override
    public SimpleRepositoryService<ListedSection> getService() {
        return this.service;
    }
}
