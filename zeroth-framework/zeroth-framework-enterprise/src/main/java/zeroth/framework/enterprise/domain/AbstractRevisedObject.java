// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import zeroth.framework.enterprise.infra.persistence.RevisedObjectListener;
/**
 * 改訂オブジェクト
 * @param <T> 改訂オブジェクト型
 * @author nilcy
 */
@MappedSuperclass
@EntityListeners(RevisedObjectListener.class)
public abstract class AbstractRevisedObject<T extends AbstractRevisedObject<T>> extends
    AbstractVersionedObject<T> implements RevisedObject<T, Long> {
    /** 識別番号 */
    private static final long serialVersionUID = 6992851617530122569L;
    /** 登録日時 */
    @Column(name = "created", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    /** 更新日時 */
    @Column(name = "updated", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    /** コンストラクタ */
    public AbstractRevisedObject() {
    }
    /**
     * {@link #created} の取得
     * @return {@link #created}
     */
    @Override
    public Date getCreated() {
        return this.created;
    }
    /**
     * {@link #created} の設定
     * @param aCreated {@link #created}
     */
    @Override
    public void setCreated(final Date aCreated) {
        this.created = aCreated;
    }
    /**
     * {@link #updated} の取得
     * @return {@link #updated}
     */
    @Override
    public Date getUpdated() {
        return this.updated;
    }
    /**
     * {@link #updated} の設定
     * @param aUpdated {@link #updated}
     */
    @Override
    public void setUpdated(final Date aUpdated) {
        this.updated = aUpdated;
    }
}
