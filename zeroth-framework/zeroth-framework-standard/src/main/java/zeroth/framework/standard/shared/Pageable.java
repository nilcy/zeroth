// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.shared;
/**
 * ページ条件I/F
 * @author nilcy
 */
public interface Pageable {
    /**
     * オフセットの取得
     * <p>
     * オフセット ＝ (ページ番号 - １) ×　ページサイズ
     * </p>
     * @return　オフセット
     */
    int getOffset();
    /**
     * ページ番号の取得
     * @return　ページ番号
     */
    int getPageNumber();
    /**
     * ページサイズの取得
     * @return　ページサイズ
     */
    int getPageSize();
    /**
     * ソート条件の取得
     * @return　ソート条件
     */
    Sort getSort();
}
