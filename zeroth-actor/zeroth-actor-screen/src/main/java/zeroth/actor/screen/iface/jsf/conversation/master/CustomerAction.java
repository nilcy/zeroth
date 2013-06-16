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
import zeroth.actor.service.app.actor.CustomerApplication;
import zeroth.actor.service.domain.Customer;
import zeroth.actor.service.domain.CustomerFactory;
import zeroth.framework.enterprise.app.SimpleRepositoryApplication;
import zeroth.framework.screen.iface.jsf.AbstractActionImpl;
import zeroth.framework.standard.shared.SimpleFilter;
/**
 * Customer action.
 * @author nilcy
 */
@Named(value = "customerAction")
@ConversationScoped
public class CustomerAction extends AbstractActionImpl<Customer, Long, SimpleFilter> {
    /** 製品番号 */
    private static final long serialVersionUID = 873776474936603723L;
    /** customer service Local-I/F. */
    @EJB
    private CustomerApplication service;
    /** コンストラクタ */
    public CustomerAction() {
        super();
    }
    @Override
    public SimpleRepositoryApplication<Customer, Long, SimpleFilter> getService() {
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
