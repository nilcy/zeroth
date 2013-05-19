// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.infra.persistence;
import java.util.Date;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import zeroth.framework.enterprise.domain.RevisedObject;
/**
 * 改訂オブジェクトリスナー
 * @author nilcy
 */
public class RevisedObjectListener {
    /** ロガー */
    @Inject
    private Logger log;
    /** コンストラクタ */
    public RevisedObjectListener() {
    }
    /**
     * 登録の前処理
     * @param aEntity 改訂オブジェクト
     */
    @PrePersist
    public void prePersist(final Object aEntity) {
        if (aEntity instanceof RevisedObject) {
            final RevisedObject<?, ?> revisedObject = (RevisedObject<?, ?>) aEntity;
            final Date now = new Date();
            revisedObject.setCreated(now);
            revisedObject.setUpdated(now);
            this.log.info("PRE-PERSISTED! -> " + revisedObject);
        }
    }
    /**
     * 更新の前処理
     * @param aEntity entity
     */
    @PreUpdate
    public void preUpdate(final Object aEntity) {
        if (aEntity instanceof RevisedObject) {
            final RevisedObject<?, ?> revisedObject = (RevisedObject<?, ?>) aEntity;
            revisedObject.setUpdated(new Date());
            this.log.info("PRE-UPDATED! -> " + revisedObject);
        }
    }
}
