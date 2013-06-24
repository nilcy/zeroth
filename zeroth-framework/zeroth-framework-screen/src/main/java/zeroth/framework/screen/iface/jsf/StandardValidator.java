// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.screen.iface.jsf;
import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
/**
 * 標準バリデータ
 * @author nilcy
 */
public class StandardValidator {
    /**
     * 画面入力の精査(ISBNコードの例)
     * @author nilcy
     */
    @FacesValidator(value = "isbnValidator")
    public class IsbnValidator implements Validator {
        /** 検索条件 */
        private final Pattern pattern = Pattern.compile("(?=[-0-9xX]{13}$)");
        @Override
        public void validate(final FacesContext aContext, final UIComponent aComponent,
            final Object aTarget) throws ValidatorException {
            final String componentValue = aTarget.toString();
            final Matcher matcher = pattern.matcher(componentValue);
            if (!matcher.find()) {
                final String message = MessageFormat.format("{0} is not a valid isbn format",
                    componentValue);
                final FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    message, message);
                throw new ValidatorException(facesMessage);
            }
        }
    }
}
