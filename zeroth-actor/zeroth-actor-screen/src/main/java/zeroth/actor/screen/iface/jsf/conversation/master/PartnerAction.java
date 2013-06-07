// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.screen.iface.jsf.conversation.master;
import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import org.apache.commons.lang3.StringUtils;
import com.kuzumeji.domain.actor.PartnerFactory;
import com.kuzumeji.entity.actor.Partner;
import zeroth.actor.screen.iface.jsf.AbstractActionImpl;
import zeroth.framework.enterprise.app.SimpleRepositoryService;
import zeroth.framework.enterprise.app.actor.PartnerServiceLocal;
/**
 * Partner action.
 * @author nilcy
 */
@Named(value = "partnerAction")
@ConversationScoped
public class PartnerAction extends AbstractActionImpl<Partner> {
    /** S/N. */
    private static final long serialVersionUID = -1406530105042380063L;
    /** partner service Local-I/F. */
    @EJB
    private PartnerServiceLocal service;
    /** Constructor. */
    public PartnerAction() {
        super();
    }
    @Override
    public SimpleRepositoryService<Partner> getService() {
        return this.service;
    }
    /** {@inheritDoc} */
    @Override
    protected Partner createInstance() {
        return new PartnerFactory().create();
    }
    /** {@inheritDoc} */
    @Override
    protected boolean beforeSave() {
        final Partner c = getSelected();
        c.getContact().setName(
            StringUtils.defaultIfEmpty(c.getContact().getName(), c.getFamilyName()));
        return super.beforeSave();
    }
}
