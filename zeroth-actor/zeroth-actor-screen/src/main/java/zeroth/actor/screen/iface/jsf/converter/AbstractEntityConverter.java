// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.screen.iface.jsf.converter;
import java.text.MessageFormat;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.apache.commons.lang3.StringUtils;
import zeroth.framework.enterprise.shared.Persistable;
import zeroth.framework.screen.iface.jsf.Action;
/**
 * Entity converter.
 * @author nilcy
 */
public abstract class AbstractEntityConverter implements Converter {
    /** faces action name. */
    private final String actionName;
    /**
     * コンストラクタ
     * @param aActionName {@link #actionName}
     */
    public AbstractEntityConverter(final String aActionName) {
        actionName = aActionName;
    }
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public Object getAsObject(final FacesContext aFacesContext, final UIComponent aComponent,
        final String aParam) {
        if (StringUtils.isEmpty(aParam)) {
            return null;
        }
        final Object object = ((Action) aFacesContext.getApplication().getELResolver()
            .getValue(aFacesContext.getELContext(), null, actionName)).getService().find(
            Long.valueOf(aParam));
        return object;
    }
    @Override
    public String getAsString(final FacesContext aFacesContext, final UIComponent aComponent,
        final Object aObject) {
        if ((aObject == null)
            || ((aObject instanceof String) && StringUtils.isEmpty((CharSequence) aObject))) {
            return null;
        } else if (aObject instanceof Persistable<?>) {
            final String string = ((Persistable<?>) aObject).identity().toString();
            return string;
        }
        throw new IllegalArgumentException(MessageFormat.format(
            "actual entity={0}, actual type={1}, expected type={2}.", aObject, aObject.getClass()
                .getName(), this.getClass().getName()));
    }
}
