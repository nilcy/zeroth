// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.screen.iface.jsf;
import java.util.List;
import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import org.apache.commons.lang3.StringUtils;
/**
 * Faces Helper.
 * @author nilcy
 */
public final class FacesHelper {
    /** Constructor. */
    private FacesHelper() {
    }
    /**
     * Add faces message.
     * @param aSeverity severity
     * @param aMessage message
     */
    public static void addFacesMessage(final FacesMessage.Severity aSeverity, final String aMessage) {
        getCurrentInstance().addMessage(null, new FacesMessage(aSeverity, aMessage, aMessage));
    }
    /**
     * Add faces messages.
     * @param aSeverity severity
     * @param aMessages messages
     */
    public static void addFacesMessages(final FacesMessage.Severity aSeverity,
        final List<String> aMessages) {
        for (final String message : aMessages) {
            addFacesMessage(aSeverity, message);
        }
    }
    /**
     * Add faces messages.
     * @param aSeverity severity
     * @param aCause cause
     * @param aDefaultMessage default message
     */
    public static void addFacesMessage(final FacesMessage.Severity aSeverity,
        final Exception aCause, final String aDefaultMessage) {
        final String message = aCause.getLocalizedMessage();
        if (!StringUtils.isEmpty(message)) {
            addFacesMessage(aSeverity, message);
        } else {
            addFacesMessage(aSeverity, aDefaultMessage);
        }
    }
    /**
     * Add success message.
     * @param aMessage success message
     */
    public static void addSuccessMessage(final String aMessage) {
        addFacesMessage(FacesMessage.SEVERITY_INFO, aMessage);
    }
    /**
     * Add success bundle message.
     * @param aKey key
     */
    public static void addSuccessBundleMessage(final String aKey) {
        addSuccessMessage(getBundleMessage(aKey));
    }
    /**
     * Get current instance.
     * @return getCurrentInstance
     */
    public static FacesContext getCurrentInstance() {
        return FacesContext.getCurrentInstance();
    }
    /**
     * Get external context.
     * @return getExternalContext
     */
    public static ExternalContext getExternalContext() {
        return getCurrentInstance().getExternalContext();
    }
    /**
     * Get flash.
     * @return flash
     */
    public static Flash getFlash() {
        return getExternalContext().getFlash();
    }
    /**
     * Get bundle.
     * @return bundle
     */
    private static ResourceBundle getBundle() {
        return ResourceBundle.getBundle(FacesProfile.BUNDLE_BASENAME, getExternalContext()
            .getRequestLocale());
    }
    /**
     * Get bundle message.
     * @param aKey key
     * @return bundle message
     */
    public static String getBundleMessage(final String aKey) {
        return getBundle().getString(aKey);
    }
    /** Keep message. */
    public static void keepMessage() {
        getExternalContext().getFlash().setKeepMessages(true);
    }
}
