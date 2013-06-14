// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.shared;
/**
 * ページ条件のマーカI/F
 * @author nilcy
 */
public interface WithPageRequest {
    /**
     * ページ条件の取得
     * @return ページ条件
     */
    PageRequest getPageRequest();
}
