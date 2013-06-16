// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.screen.iface.jsf.converter;
import javax.faces.convert.FacesConverter;
import zeroth.actor.service.domain.Member;
/**
 * Member converter.
 * @author nilcy
 */
@FacesConverter(value = "memberConverter", forClass = Member.class)
public final class MemberConverter extends AbstractEntityConverter {
    /** コンストラクタ */
    public MemberConverter() {
        super("memberAction");
    }
}
