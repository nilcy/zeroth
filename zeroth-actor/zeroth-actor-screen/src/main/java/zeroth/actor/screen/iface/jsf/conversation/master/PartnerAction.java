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
import zeroth.actor.app.actor.PartnerServiceLocal;
import zeroth.actor.domain.Partner;
import zeroth.actor.domain.PartnerFactory;
import zeroth.framework.enterprise.app.SimpleRepositoryService;
import zeroth.framework.screen.iface.jsf.AbstractActionImpl;
/**
 * Partner action.
 * @author nilcy
 */
@Named(value = "partnerAction")
@ConversationScoped
public class PartnerAction extends AbstractActionImpl<Partner, Long, Partner> {
    /** 製品番号 */
    private static final long serialVersionUID = -1406530105042380063L;
    /** partner service Local-I/F. */
    @EJB
    private PartnerServiceLocal service;
    /** コンストラクタ */
    public PartnerAction() {
        super();
    }
    @Override
    public SimpleRepositoryService<Partner, Long, Partner> getService() {
        return service;
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
