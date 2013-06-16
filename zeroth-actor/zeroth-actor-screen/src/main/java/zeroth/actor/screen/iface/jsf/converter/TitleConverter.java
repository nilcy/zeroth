// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.screen.iface.jsf.converter;
import javax.faces.convert.FacesConverter;
import zeroth.actor.service.domain.misc.IndustryClass;
/**
 * Title converter.
 * @author nilcy
 */
@FacesConverter(value = "titleConverter", forClass = IndustryClass.class)
public final class TitleConverter extends AbstractEntityConverter {
    /** コンストラクタ */
    public TitleConverter() {
        super("titleAction");
    }
}
