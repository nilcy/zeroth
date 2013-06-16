// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.screen.iface.jsf.converter;
import javax.faces.convert.FacesConverter;
import zeroth.actor.service.domain.Organ;
/**
 * Organ converter.
 * @author nilcy
 */
@FacesConverter(value = "organConverter", forClass = Organ.class)
public final class OrganConverter extends AbstractEntityConverter {
    /** コンストラクタ */
    public OrganConverter() {
        super("organAction");
    }
}
