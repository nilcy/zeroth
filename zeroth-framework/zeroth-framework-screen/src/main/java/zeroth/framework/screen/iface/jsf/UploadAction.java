// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.screen.iface.jsf;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
/**
 * ファイルアップロードのアクション
 * @author nilcy
 */
@Named("uploadAction")
@ConversationScoped
public class UploadAction implements Action {
    /** 製品番号 */
    private static final long serialVersionUID = 6484385194875662068L;
    /** マルチパートのファイル */
    private Part file = null;
    /** ロガー */
    @Inject
    private Logger logger;
    /** コンストラクタ */
    public UploadAction() {
    }
    /**
     * ファイルアップロード
     */
    public void uploadFile() {
        try (InputStream is = file.getInputStream();) {
            // FacesHelper.getExternalContext().getApplicationContextPath();
            try (FileOutputStream fos = new FileOutputStream("/zeroth/" + getFileName(file));) {
                final byte[] buf = new byte[1024];
                int len = 0;
                while ((len = is.read(buf)) >= 0) {
                    fos.write(buf, 0, len);
                }
            }
        } catch (final IOException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }
    /**
     * ファイル名の取得
     * @param part マルチパート
     * @return ファイル名
     */
    private static String getFileName(final Part part) {
        for (final String cd : part.getHeader("Content-Disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
    /**
     * マルチパートファイルの取得
     * @return マルチパートファイル
     */
    public Part getFile() {
        return file;
    }
    /**
     * マルチパートファイルの設定
     * @param file マルチパートファイル
     */
    public void setFile(final Part file) {
        this.file = file;
    }
}
