// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.screen.iface.jsf.converter;
import java.text.MessageFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import zeroth.framework.screen.iface.jsf.FacesHelper;
/**
 * Date converter.
 * @author nilcy
 */
@FacesConverter(value = "dateConverter")
public class DateConverter implements Converter {
    /** formal patter. */
    private static final String FORMAL_PATTERN = "yyyy/MM/dd";
    /** length of MMDD. */
    private static final int LENGTH_MMDD = 4;
    /** length of DD. */
    private static final int LENGTH_DD = 2;
    /** コンストラクタ */
    public DateConverter() {
        super();
    }
    @Override
    public Object getAsObject(final FacesContext aContext, final UIComponent aUIComponent,
        final String aParam) {
        if (StringUtils.isEmpty(aParam)) {
            return null;
        }
        try {
            return createDate(StringUtils.trimToEmpty(aParam));
        } catch (final ParseException e) {
            final String msg = MessageFormat.format(FacesHelper
                .getBundleMessage("zeroth.actor.screen.iface.jsf.converter.DateConverter"), aParam,
                "YYYY/MM/DD, YYYYMMDD, YYMMDD, MMDD, DD");
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
        }
    }
    @Override
    public String getAsString(final FacesContext aContext, final UIComponent aUIComponent,
        final Object aObject) {
        if (aObject == null) {
            return null;
        }
        return DateFormatUtils.format((Date) aObject, FORMAL_PATTERN);
    }
    /**
     * Create date.
     * @param aDateText date text
     * @return created date
     * @throws ParseException parse exception
     */
    private static Date createDate(final String aDateText) throws ParseException {
        final Calendar cal = Calendar.getInstance();
        final Date now = cal.getTime();
        Date date = DateUtils.parseDateStrictly(aDateText, new String[] { FORMAL_PATTERN,
            "yyyyMMdd", "yyMMdd", "MMdd", "dd" });
        if (aDateText.length() == LENGTH_MMDD) {
            date = DateUtils.setYears(date, cal.get(Calendar.YEAR));
            if (date.before(now)) {
                date = DateUtils.addYears(date, 1);
            }
        } else if (aDateText.length() == LENGTH_DD) {
            date = DateUtils.setYears(date, cal.get(Calendar.YEAR));
            date = DateUtils.setMonths(date, cal.get(Calendar.MONTH));
            if (date.before(now)) {
                date = DateUtils.addMonths(date, 1);
            }
        }
        return date;
    }
}
