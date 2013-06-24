// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.screen.iface.jsf;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;
import javax.el.ValueExpression;
import javax.faces.FacesException;
import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.lang3.StringUtils;
/**
 * アップロードのレンダラ
 * @author nilcy
 */
@FacesRenderer(componentFamily = "javax.faces.Input", rendererType = "zeroth.faces.Upload")
public class UploadRenderer extends Renderer {
    /** inputタグ */
    private static final String TAG_INPUT = "input";
    /** typeタグ */
    private static final String TAG_TYPE = "type";
    /** fileタグ */
    private static final String TAG_FILE = "file";
    /** nameタグ */
    private static final String TAG_NAME = "name";
    /** clientIdタグ */
    private static final String TAG_CLIENT_ID = "clientId";
    /** 記録者 */
    private static final Logger LOG = Logger.getAnonymousLogger();
    /** 実体化 */
    public UploadRenderer() {
        super();
    }
    /** {@inheritDoc} */
    @SuppressWarnings("resource")
    @Override
    public void encodeBegin(final FacesContext context, final UIComponent component)
        throws IOException {
        if (!component.isRendered()) {
            return;
        }
        final ResponseWriter writer = context.getResponseWriter();
        final String clientId = component.getClientId(context);
        writer.startElement(TAG_INPUT, component);
        writer.writeAttribute(TAG_TYPE, TAG_FILE, TAG_TYPE);
        writer.writeAttribute(TAG_NAME, clientId, TAG_CLIENT_ID);
        writer.endElement(TAG_INPUT);
        writer.flush();
    }
    /** {@inheritDoc} */
    @Override
    public void decode(final FacesContext context, final UIComponent component) {
        final ExternalContext external = context.getExternalContext();
        final HttpServletRequest request = (HttpServletRequest) external.getRequest();
        final String clientId = component.getClientId(context);
        final FileItem item = (FileItem) request.getAttribute(clientId);
        if ((item == null) || StringUtils.isEmpty(item.getName())) {
            return;
        }
        LOG.fine("item:" + item);
        final ValueExpression valueExpr = component.getValueExpression("value");
        if (valueExpr != null) {
            ((EditableValueHolder) component).setSubmittedValue(findSubmittedValue(request, item,
                valueExpr.getType(context.getELContext())));
            ((EditableValueHolder) component).setValid(true);
        }
        final Object target = component.getAttributes().get("target");
        LOG.fine("target=" + target);
        if (target != null) {
            File file;
            if (target instanceof File) {
                file = (File) target;
            } else {
                final ServletContext servletContext = (ServletContext) external.getContext();
                final String itemName = item.getName();
                final String dirPath = "WEB-INF/" + target;
                LOG.fine("dirPath=" + dirPath);
                new File(servletContext.getRealPath(dirPath)).mkdirs();
                final String filePath = dirPath + "/" + itemName;
                final String realPath = servletContext.getRealPath(filePath);
                LOG.fine("realPath=" + realPath);
                file = new File(realPath);
            }
            // UGH 汎用例外クラスを捕捉したくないがcommons-upload仕様が…
            try {
                LOG.fine("item.write");
                item.write(file);
            } catch (final Exception ex) {
                throw new FacesException(ex);
            }
        }
    }
    /**
     * 画面値の取得
     * @param request HTTP要求
     * @param item FILE項目
     * @param valueType 値型
     * @return 画面値
     * @throws FacesException 画面例外
     */
    @SuppressWarnings("static-method")
    private Object findSubmittedValue(final HttpServletRequest request, final FileItem item,
        final Class<?> valueType) throws FacesException {
        Object newValue;
        if (valueType == byte[].class) {
            newValue = item.get();
        } else if (valueType == InputStream.class) {
            try {
                newValue = item.getInputStream();
            } catch (final IOException ex) {
                throw new FacesException(ex);
            }
        } else {
            final String encoding = request.getCharacterEncoding();
            if (encoding != null) {
                try {
                    newValue = item.getString(encoding);
                } catch (final UnsupportedEncodingException ex) {
                    newValue = item.getString();
                }
            } else {
                newValue = item.getString();
            }
        }
        return newValue;
    }
}
