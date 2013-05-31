// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;
/**
 * テストオブジェクト
 * @author nilcy
 */
@Entity
@Table(name = "TestExample")
@SuppressWarnings("all")
public class TestExample extends AbstractPersistable<TestExample> {
    @Column(name = "code", nullable = false)
    private String code;
    @Column(name = "version", nullable = false)
    @Version
    private Long version;
    public TestExample() {
    }
    public TestExample(final String aCode) {
        this.code = aCode;
    }
    public String getCode() {
        return this.code;
    }
    public void setCode(final String aCode) {
        this.code = aCode;
    }
    public Long getVersion() {
        return this.version;
    }
    public void setVersion(final Long aVersion) {
        this.version = aVersion;
    }
}
