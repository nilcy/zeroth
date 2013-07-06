// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.screen.iface.jsf.conversation.master;
import java.math.BigDecimal;
import java.text.MessageFormat;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;
import zeroth.actor.service.app.ApplicationAnnotation.OrganApplicationCDI;
import zeroth.actor.service.app.actor.OrganApplication;
import zeroth.actor.service.domain.Organ;
import zeroth.framework.enterprise.app.SimpleRepositoryApplication;
import zeroth.framework.screen.iface.jsf.AbstractActionImpl;
import zeroth.framework.screen.iface.jsf.FacesHelper;
import zeroth.framework.standard.shared.FilterFactory;
import zeroth.framework.standard.shared.SimpleFilter;
/**
 * 組織アクション
 * @author nilcy
 */
@Named(value = "organAction")
@ConversationScoped
public class OrganAction extends AbstractActionImpl<Organ, BigDecimal, SimpleFilter> {
    /** 製品番号 */
    private static final long serialVersionUID = 7243039551620767571L;
    /** 組織アプリケーションI/F */
    @Inject
    @OrganApplicationCDI
    private OrganApplication organApplication;
    /** コンストラクタ */
    public OrganAction() {
    }
    /** {@inheritDoc} */
    @Override
    public SimpleRepositoryApplication<Organ, BigDecimal, SimpleFilter> getApplication() {
        return organApplication;
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
    /** {@inheritDoc} */
    @Override
    protected SimpleFilter createFilter() {
        return FilterFactory.createSimpleFilter();
    }
}
