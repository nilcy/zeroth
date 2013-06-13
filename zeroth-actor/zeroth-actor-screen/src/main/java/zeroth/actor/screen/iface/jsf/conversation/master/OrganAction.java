// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.screen.iface.jsf.conversation.master;
import java.text.MessageFormat;
import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import zeroth.actor.app.actor.OrganServiceLocal;
import zeroth.actor.domain.Organ;
import zeroth.framework.enterprise.app.SimpleRepositoryService;
import zeroth.framework.screen.iface.jsf.AbstractActionImpl;
import zeroth.framework.screen.iface.jsf.FacesHelper;
/**
 * Organization action.
 * @author nilcy
 */
@Named(value = "organAction")
@ConversationScoped
public class OrganAction extends AbstractActionImpl<Organ, Long, Organ> {
    /** S/N. */
    private static final long serialVersionUID = 7243039551620767571L;
    /** organization service Local-I/F. */
    @EJB
    private OrganServiceLocal service;
    /** コンストラクタ */
    public OrganAction() {
        super();
    }
    @Override
    public SimpleRepositoryService<Organ, Long, Organ> getService() {
        return service;
    }
    /** {@inheritDoc} false if parent >= target. */
    @Override
    protected boolean beforeSave() {
        final Organ target = getSelected();
        final Organ parent = target.getParent();
        if ((parent != null) && (parent.getLevel().longValue() >= target.getLevel().longValue())) {
            FacesHelper.addFacesMessage(
                FacesMessage.SEVERITY_ERROR,
                MessageFormat.format(FacesHelper.getBundleMessage("Organ_ERR_parent"),
                    parent.getLevel()));
            return false;
        }
        return super.beforeSave();
    }
}
