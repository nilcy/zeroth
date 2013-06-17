// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.shared;
import java.io.Serializable;
import java.util.Date;
/**
 * 監査可能エンティティI/F
 * @param <U> 利用者オブジェクト型
 * @param <ID> 識別子オブジェクト型
 * @author nilcy
 */
public interface Auditable<U, ID extends Serializable> extends Versionable<ID> {
    /**
     * 作成者の取得
     * @return 作成者
     */
    U getCreatedBy();
    /**
     * 作成者の設定
     * @param createdBy 作成者
     */
    void setCreatedBy(U createdBy);
    /**
     * 作成日時の取得
     * @return 作成日時の取得
     */
    Date getCreatedDate();
    /**
     * 作成日時の設定
     * @param createdDate 作成日時
     */
    void setCreatedDate(Date createdDate);
    /**
     * 最終更新者の取得
     * @return 最終更新者
     */
    U getLastModifiedBy();
    /**
     * 最終更新者の設定
     * @param lastModifiedBy 最終更新者
     */
    void setLastModifiedBy(U lastModifiedBy);
    /**
     * 最終更新日時の取得
     * @return 最終更新日時
     */
    Date getLastModifiedDate();
    /**
     * 最終更新日時の設定
     * @param lastModifiedDate 最終更新日時
     */
    void setLastModifiedDate(Date lastModifiedDate);
}
