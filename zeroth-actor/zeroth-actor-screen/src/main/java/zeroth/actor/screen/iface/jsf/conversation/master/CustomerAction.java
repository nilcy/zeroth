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
import zeroth.actor.app.actor.CustomerServiceLocal;
import zeroth.actor.domain.Customer;
import zeroth.actor.domain.CustomerFactory;
import zeroth.framework.enterprise.app.SimpleRepositoryService;
import zeroth.framework.screen.iface.jsf.AbstractActionImpl;
/**
 * Customer action.
 * @author nilcy
 */
@Named(value = "customerAction")
@ConversationScoped
public class CustomerAction extends AbstractActionImpl<Customer, Long, Customer> {
    /** S/N. */
    private static final long serialVersionUID = 873776474936603723L;
    /** customer service Local-I/F. */
    @EJB
    private CustomerServiceLocal service;
    /** コンストラクタ */
    public CustomerAction() {
        super();
    }
    @Override
    public SimpleRepositoryService<Customer, Long, Customer> getService() {
        return service;
    }
    /** {@inheritDoc} */
    @Override
    protected Customer createInstance() {
        return new CustomerFactory().create();
    }
    /** {@inheritDoc} */
    @Override
    protected boolean beforeSave() {
        final Customer c = getSelected();
        c.getAddress().setName(
            StringUtils.defaultIfEmpty(c.getAddress().getName(), c.getOfficialName()));
        c.getContact().setName(
            StringUtils.defaultIfEmpty(c.getContact().getName(), c.getOfficialName()));
        return super.beforeSave();
    }
}
