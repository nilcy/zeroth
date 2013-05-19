// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
import java.util.Date;
/**
 * 改訂オブジェクトI/F
 * @param <T> 改訂オブジェクト型
 * @param <ID> 識別子オブジェクト型
 * @author nilcy
 */
public interface RevisedObject<T extends RevisedObject<T, ID>, ID> extends ReferenceObject<T, ID> {
    /**
     * 登録日時の取得
     * @return 登録日時
     */
    Date getCreated();
    /**
     * 登録日時の設定
     * @param aCreated 登録日時
     */
    void setCreated(final Date aCreated);
    /**
     * 更新日時の取得
     * @return 更新日時
     */
    Date getUpdated();
    /**
     * 更新日時の設定
     * @param aUpdated 更新日時
     */
    void setUpdated(final Date aUpdated);
}
