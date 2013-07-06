// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.screen.iface.jsf.conversation.master;
import java.math.BigDecimal;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.commons.lang3.StringUtils;
import zeroth.actor.service.app.ApplicationAnnotation.CustomerApplicationCDI;
import zeroth.actor.service.app.actor.CustomerApplication;
import zeroth.actor.service.domain.Customer;
import zeroth.actor.service.domain.CustomerFactory;
import zeroth.framework.enterprise.app.SimpleRepositoryApplication;
import zeroth.framework.screen.iface.jsf.AbstractActionImpl;
import zeroth.framework.standard.shared.FilterFactory;
import zeroth.framework.standard.shared.SimpleFilter;
/**
 * 得意先アクション
 * @author nilcy
 */
@Named(value = "customerAction")
@ConversationScoped
public class CustomerAction extends AbstractActionImpl<Customer, BigDecimal, SimpleFilter> {
    /** 製品番号 */
    private static final long serialVersionUID = 873776474936603723L;
    /** 得意先アプリケーションI/F */
    @Inject
    @CustomerApplicationCDI
    private CustomerApplication customerApplication;
    /** コンストラクタ */
    public CustomerAction() {
    }
    /** {@inheritDoc} */
    @Override
    public SimpleRepositoryApplication<Customer, BigDecimal, SimpleFilter> getApplication() {
        return customerApplication;
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
    /** {@inheritDoc} */
    @Override
    protected SimpleFilter createFilter() {
        return FilterFactory.createSimpleFilter();
    }
}
