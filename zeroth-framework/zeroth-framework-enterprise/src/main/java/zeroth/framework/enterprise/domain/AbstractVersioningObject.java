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
import javax.persistence.Version;
/**
 * 版管理オブジェクト
 * @param <T> 版管理オブジェクト型
 * @author nilcy
 */
@MappedSuperclass
public abstract class AbstractVersioningObject<T extends AbstractVersioningObject<T>> extends
    AbstractReferenceObject<T> implements VersioningObject<T> {
    /** 識別番号 */
    private static final long serialVersionUID = 3326380823292476211L;
    /** ID. */
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /** Version. */
    @Column
    @Version
    private Long version;
    /** コンストラクタ */
    public AbstractVersioningObject() {
    }
    @Override
    public Long getId() {
        return this.id;
    }
    @Override
    public void setId(final Long id) {
        this.id = id;
    }
    @Override
    public Long getVersion() {
        return this.version;
    }
    @Override
    public void setVersion(final Long version) {
        this.version = version;
    }
}
