// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.screen.iface.web.servlet;
import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Logout servlet.
 * @author nilcy
 */
@WebServlet(name = "logoutServlet", urlPatterns = { "/logout" })
public class LogoutServlet extends HttpServlet {
    /** S/N. */
    private static final long serialVersionUID = -2564378030285785954L;
    /** コンストラクタ */
    public LogoutServlet() {
        super();
    }
    @Override
    protected void doGet(final HttpServletRequest aRequest, final HttpServletResponse aResponse) {
        try {
            if (aRequest.getUserPrincipal() != null) {
                aRequest.logout();
                aRequest.getSession().invalidate();
            }
            aResponse.sendRedirect(aRequest.getContextPath() + "/index.xhtml");
        } catch (final ServletException e) {
            Logger.getGlobal().severe(e.getMessage());
        } catch (final IOException e) {
            Logger.getGlobal().severe(e.getMessage());
        }
    }
}
