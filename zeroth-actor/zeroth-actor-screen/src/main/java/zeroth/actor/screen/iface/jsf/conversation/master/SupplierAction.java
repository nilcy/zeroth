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
import zeroth.actor.app.actor.SupplierApplication;
import zeroth.actor.domain.Supplier;
import zeroth.actor.domain.SupplierFactory;
import zeroth.framework.enterprise.app.SimpleRepositoryApplication;
import zeroth.framework.screen.iface.jsf.AbstractActionImpl;
/**
 * Supplier action.
 * @author nilcy
 */
@Named(value = "supplierAction")
@ConversationScoped
public class SupplierAction extends AbstractActionImpl<Supplier, Long, Supplier> {
    /** 製品番号 */
    private static final long serialVersionUID = 873776474936603723L;
    /** supplier service Local-I/F. */
    @EJB
    private SupplierApplication service;
    /** コンストラクタ */
    public SupplierAction() {
        super();
    }
    @Override
    public SimpleRepositoryApplication<Supplier, Long, Supplier> getService() {
        return service;
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
