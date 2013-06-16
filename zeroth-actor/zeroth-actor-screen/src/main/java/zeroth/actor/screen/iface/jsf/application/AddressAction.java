// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.screen.iface.jsf.application;
import java.io.Serializable;
import javax.ejb.Singleton;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.commons.lang3.Validate;
import zeroth.actor.service.domain.parts.Address;
import zeroth.actor.service.domain.parts.HomeAddress;
import zeroth.actor.service.domain.parts.OfficeAddress;
/**
 * Address action.
 * @author nilcy
 */
@Named("addressAction")
@ApplicationScoped
@Singleton
// @Startup
public class AddressAction implements Serializable {
    /** 製品番号 */
    private static final long serialVersionUID = -1455192251688608331L;
    /** home address action. */
    @Inject
    private HomeAddressAction homeAction;
    /** office address action. */
    @Inject
    private OfficeAddressAction officeAction;
    /** コンストラクタ */
    public AddressAction() {
        super();
    }
    /**
     * Load address.
     * @param aAddress address
     * @return true if found
     */
    public boolean load(final Address<?> aAddress) {
        Validate.notNull(aAddress);
        Validate.notNull(aAddress.getCode());
        boolean found = false;
        if (aAddress instanceof HomeAddress) {
            found = homeAction.load(aAddress);
        } else if (aAddress instanceof OfficeAddress) {
            found = officeAction.load((OfficeAddress) aAddress);
            if (!found) {
                found = homeAction.load(aAddress);
            }
        }
        return found;
    }
}
