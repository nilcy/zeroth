// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
import java.util.Date;
import java.util.logging.Logger;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import zeroth.framework.enterprise.domain.Auditable;
/**
 * 改訂オブジェクトリスナー
 * @author nilcy
 */
public class AuditableListener {
    /** ロガー */
    private final Logger log = Logger.getLogger(this.getClass().getName());
    /** コンストラクタ */
    public AuditableListener() {
    }
    /**
     * 登録の前処理
     * @param aEntity 改訂オブジェクト
     */
    @PrePersist
    public void prePersist(final Object aEntity) {
        if (aEntity instanceof Auditable) {
            final Auditable<?, ?> Auditable = (Auditable<?, ?>) aEntity;
            final Date now = new Date();
            Auditable.setCreatedDate(now);
            Auditable.setLastModifiedDate(now);
            this.log.info("PRE-PERSISTED! -> " + Auditable);
        }
    }
    /**
     * 更新の前処理
     * @param aEntity entity
     */
    @PreUpdate
    public void preUpdate(final Object aEntity) {
        if (aEntity instanceof Auditable) {
            final Auditable<?, ?> Auditable = (Auditable<?, ?>) aEntity;
            Auditable.setLastModifiedDate(new Date());
            this.log.info("PRE-UPDATED! -> " + Auditable);
        }
    }
}
