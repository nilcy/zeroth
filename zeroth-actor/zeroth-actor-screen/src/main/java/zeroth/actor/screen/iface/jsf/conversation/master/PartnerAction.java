// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.screen.iface.jsf.conversation.master;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.commons.lang3.StringUtils;
import zeroth.actor.screen.app.ApplicationAnnotation.PartnerApplicationCDI;
import zeroth.actor.service.app.actor.PartnerApplication;
import zeroth.actor.service.domain.Partner;
import zeroth.actor.service.domain.PartnerFactory;
import zeroth.framework.enterprise.app.SimpleRepositoryApplication;
import zeroth.framework.screen.iface.jsf.AbstractActionImpl;
import zeroth.framework.standard.shared.FilterFactory;
import zeroth.framework.standard.shared.SimpleFilter;
/**
 * 外注アクション
 * @author nilcy
 */
@Named(value = "partnerAction")
@ConversationScoped
public class PartnerAction extends AbstractActionImpl<Partner, Long, SimpleFilter> {
    /** 製品番号 */
    private static final long serialVersionUID = -1406530105042380063L;
    /** 外注アプリケーションI/F */
    @Inject
    @PartnerApplicationCDI
    private PartnerApplication partnerApplication;
    /** コンストラクタ */
    public PartnerAction() {
    }
    /** {@inheritDoc} */
    @Override
    public SimpleRepositoryApplication<Partner, Long, SimpleFilter> getApplication() {
        return partnerApplication;
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
    /** {@inheritDoc} */
    @Override
    protected SimpleFilter createFilter() {
        return FilterFactory.createSimpleFilter();
    }
}
