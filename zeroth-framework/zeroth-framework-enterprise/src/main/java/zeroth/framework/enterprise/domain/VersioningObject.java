// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
/**
 * 版管理オブジェクトI/F
 * @param <T> 版管理オブジェクト型
 * @author nilcy
 */
public interface VersioningObject<T extends VersioningObject<T>> extends ReferenceObject<T> {
    /**
     * 版数の取得
     * @return 版数
     */
    Long getVersion();
    /**
     * 版数の設定
     * @param aVersion 版数
     */
    void setVersion(Long aVersion);
}
