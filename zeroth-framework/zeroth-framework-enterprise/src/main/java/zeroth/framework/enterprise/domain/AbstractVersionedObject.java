// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
/**
 * 版管理オブジェクト
 * @param <T> 版管理オブジェクト型
 * @author nilcy
 */
@MappedSuperclass
public abstract class AbstractVersionedObject<T extends AbstractVersionedObject<T>> extends
    AbstractReferenceObject<T> implements VersionedObject<T, Long> {
    /** 識別番号 */
    private static final long serialVersionUID = 3326380823292476211L;
    /** 版数 */
    @Column
    @Version
    private Long version;
    /** コンストラクタ */
    public AbstractVersionedObject() {
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
