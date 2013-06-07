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
import com.kuzumeji.domain.actor.CustomerFactory;
import com.kuzumeji.entity.actor.Customer;
import zeroth.actor.screen.iface.jsf.AbstractActionImpl;
import zeroth.framework.enterprise.app.SimpleRepositoryService;
import zeroth.framework.enterprise.app.actor.CustomerServiceLocal;
/**
 * Customer action.
 * @author nilcy
 */
@Named(value = "customerAction")
@ConversationScoped
public class CustomerAction extends AbstractActionImpl<Customer> {
    /** S/N. */
    private static final long serialVersionUID = 873776474936603723L;
    /** customer service Local-I/F. */
    @EJB
    private CustomerServiceLocal service;
    /** Constructor. */
    public CustomerAction() {
        super();
    }
    @Override
    public SimpleRepositoryService<Customer> getService() {
        return this.service;
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
