// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.apache.commons.lang3.builder.EqualsBuilder;
import zeroth.framework.standard.domain.ReferenceObject;
import zeroth.framework.standard.shared.AbstractDataObject;
/**
 * 参照オブジェクト
 * @param <T> 参照オブジェクト型
 * @author nilcy
 */
@MappedSuperclass
public abstract class AbstractReferenceObject<T extends AbstractReferenceObject<T>> extends
    AbstractDataObject<T> implements ReferenceObject<T, Long> {
    /** 識別番号 */
    private static final long serialVersionUID = 6765184066419433024L;
    /** ID */
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    /** コンストラクタ */
    public AbstractReferenceObject() {
    }
    /**
     * {@link #id} の取得
     * @return {@link #id}
     */
    public Long getId() {
        return this.id;
    }
    /**
     * {@link #id} の設定
     * @param aId {@link #id}
     */
    public void setId(final Long aId) {
        this.id = aId;
    }
    /** {@inheritDoc} */
    @Override
    public boolean sameIdentityAs(final T aOther) {
        return (aOther != null) && new EqualsBuilder().append(this.id, aOther.getId()).isEquals();
    }
    /** {@inheritDoc} */
    @Override
    public Long identity() {
        return getId();
    }
}
