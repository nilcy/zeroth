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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * 監査可能エンティティ
 * <p>
 * 登録日時と最終更新日時はコールバックにより自動設定するのでクライアントが設定する必要はない。
 * </p>
 * @param <T> 監査可能エンティティ型
 * @author nilcy
 */
@MappedSuperclass
@EntityListeners(AuditableListener.class)
public abstract class AbstractAuditable<T extends AbstractAuditable<T>> extends
    AbstractPersistable<T> implements Auditable<Long, Long> {
    /** 識別番号 */
    private static final long serialVersionUID = 6992851617530122569L;
    /** 作成者(ID) */
    @Column(name = "createdBy", nullable = true, insertable = true, updatable = false)
    private Long createdBy;
    /** 登録日時 */
    @Column(name = "createdDate", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    /** 最終更新者(ID) */
    @Column(name = "lastModifiedBy", nullable = true, insertable = true, updatable = true)
    private Long lastModifiedBy;
    /** 最終更新日時 */
    @Column(name = "lastModifiedDate", nullable = true, insertable = true, updatable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    /** コンストラクタ */
    public AbstractAuditable() {
    }
    @Override
    public Long getCreatedBy() {
        return this.createdBy;
    }
    @Override
    public void setCreatedBy(final Long aCreatedBy) {
        this.createdBy = aCreatedBy;
    }
    @Override
    public Date getCreatedDate() {
        return this.createdDate;
    }
    @Override
    public void setCreatedDate(final Date aCreatedDate) {
        this.createdDate = aCreatedDate;
    }
    @Override
    public Long getLastModifiedBy() {
        return this.lastModifiedBy;
    }
    @Override
    public void setLastModifiedBy(final Long aLastModifiedBy) {
        this.lastModifiedBy = aLastModifiedBy;
    }
    @Override
    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }
    @Override
    public void setLastModifiedDate(final Date aLastModifiedDate) {
        this.lastModifiedDate = aLastModifiedDate;
    }
    /**
     * 登録前コールバック
     * <p>
     * 登録日時と最終更新日時に現在日時を設定する。
     * </p>
     */
    @PrePersist
    private void prePersist() {
        final Date now = new Date();
        this.createdDate = now;
        this.lastModifiedDate = now;
    }
    /**
     * 更新前コールバック
     * <p>
     * 最終更新日時に現在日時を設定する。
     * </p>
     */
    @PreUpdate
    private void preUpdate() {
        this.lastModifiedDate = new Date();
    }
}
