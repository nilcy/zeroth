// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.screen.iface.jsf.conversation.master;
import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import zeroth.actor.service.app.misc.ListedSectionApplication;
import zeroth.actor.service.domain.misc.ListedSection;
import zeroth.framework.enterprise.app.SimpleRepositoryApplication;
import zeroth.framework.screen.iface.jsf.AbstractActionImpl;
/**
 * Listed section action.
 * @author nilcy
 */
@Named(value = "listedSectionAction")
@ConversationScoped
public class ListedSectionAction extends AbstractActionImpl<ListedSection, Long, ListedSection> {
    /** 製品番号 */
    private static final long serialVersionUID = 7243039551620767571L;
    /** listed section service Local-I/F. */
    @EJB
    private ListedSectionApplication service;
    /** コンストラクタ */
    public ListedSectionAction() {
        super();
    }
    @Override
    public SimpleRepositoryApplication<ListedSection, Long, ListedSection> getService() {
        return service;
    }
}
