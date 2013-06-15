// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.screen.iface.jsf.conversation.master;
import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import zeroth.actor.app.misc.IndustryClassServiceLocal;
import zeroth.actor.domain.misc.IndustryClass;
import zeroth.framework.enterprise.app.SimpleRepositoryApplication;
import zeroth.framework.screen.iface.jsf.AbstractActionImpl;
/**
 * Industry classification action.
 * @author nilcy
 */
@Named(value = "industryClassAction")
@ConversationScoped
public class IndustryClassAction extends AbstractActionImpl<IndustryClass, Long, IndustryClass> {
    /** 製品番号 */
    private static final long serialVersionUID = 7243039551620767571L;
    /** industry classification service Local-I/F. */
    @EJB
    private IndustryClassServiceLocal service;
    /** コンストラクタ */
    public IndustryClassAction() {
        super();
    }
    @Override
    public SimpleRepositoryApplication<IndustryClass, Long, IndustryClass> getService() {
        return service;
    }
}
