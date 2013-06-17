// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.shared;
import java.io.Serializable;
/**
 * 版管理エンティティI/F
 * @param <ID> 識別子オブジェクト型
 * @author nilcy
 */
public interface Versionable<ID extends Serializable> extends Persistable<ID> {
    /**
     * 版数の取得
     * @return 版数
     */
    Long getVersion();
    /**
     * 版数の設定
     * @param version 版数
     */
    void setVersion(Long version);
}
