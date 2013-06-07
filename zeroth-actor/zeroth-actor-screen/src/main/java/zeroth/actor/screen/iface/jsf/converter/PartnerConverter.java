// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.screen.iface.jsf.converter;
import javax.faces.convert.FacesConverter;
import com.kuzumeji.entity.actor.Partner;
/**
 * Partner converter.
 * @author nilcy
 */
@FacesConverter(value = "partnerConverter", forClass = Partner.class)
public final class PartnerConverter extends AbstractEntityConverter {
    /** Constructor. */
    public PartnerConverter() {
        super("partnerAction");
    }
}
