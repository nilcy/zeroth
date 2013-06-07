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
import com.kuzumeji.domain.actor.SupplierFactory;
import com.kuzumeji.entity.actor.Supplier;
import zeroth.actor.screen.iface.jsf.AbstractActionImpl;
import zeroth.framework.enterprise.app.SimpleRepositoryService;
import zeroth.framework.enterprise.app.actor.SupplierServiceLocal;
/**
 * Supplier action.
 * @author nilcy
 */
@Named(value = "supplierAction")
@ConversationScoped
public class SupplierAction extends AbstractActionImpl<Supplier> {
    /** S/N. */
    private static final long serialVersionUID = 873776474936603723L;
    /** supplier service Local-I/F. */
    @EJB
    private SupplierServiceLocal service;
    /** Constructor. */
    public SupplierAction() {
        super();
    }
    @Override
    public SimpleRepositoryService<Supplier> getService() {
        return this.service;
    }
    /** {@inheritDoc} */
    @Override
    protected Supplier createInstance() {
        return new SupplierFactory().create();
    }
    /** {@inheritDoc} */
    @Override
    protected boolean beforeSave() {
        final Supplier c = getSelected();
        c.getAddress().setName(
            StringUtils.defaultIfEmpty(c.getAddress().getName(), c.getOfficialName()));
        c.getContact().setName(
            StringUtils.defaultIfEmpty(c.getContact().getName(), c.getOfficialName()));
        return super.beforeSave();
    }
}
