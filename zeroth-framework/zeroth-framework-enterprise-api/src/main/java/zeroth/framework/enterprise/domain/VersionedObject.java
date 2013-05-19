// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
/**
 * 版管理オブジェクトI/F
 * @param <T> 版管理オブジェクト型
 * @param <ID> 識別子オブジェクト型
 * @author nilcy
 */
public interface VersionedObject<T extends VersionedObject<T, ID>, ID> extends
    ReferenceObject<T, ID> {
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
