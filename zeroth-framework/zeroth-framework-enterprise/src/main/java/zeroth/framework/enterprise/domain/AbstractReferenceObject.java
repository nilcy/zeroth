// ========================================================================
// Copyright (C) IMPULSE Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import zeroth.framework.standard.shared.AbstractDataObject;
/**
 * 参照オブジェクト
 * @param <T> 参照オブジェクト型
 * @author nilcy
 */
@MappedSuperclass
public abstract class AbstractReferenceObject<T extends AbstractReferenceObject<T>> extends
    AbstractDataObject<T> implements ReferenceObject<T> {
    /** 識別番号 */
    private static final long serialVersionUID = 6765184066419433024L;
    /** ID. */
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /** コンストラクタ */
    public AbstractReferenceObject() {
    }
    @Override
    public Long getId() {
        return this.id;
    }
    @Override
    public void setId(final Long id) {
        this.id = id;
    }
}
