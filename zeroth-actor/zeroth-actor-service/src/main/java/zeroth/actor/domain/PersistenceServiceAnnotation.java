// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.domain;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.inject.Qualifier;
/**
 * データ永続化サービスのアノテーション
 * @author nilcy
 */
public @interface PersistenceServiceAnnotation {
    /** 得意先データ永続化サービス */
    @Qualifier
    @Target({ ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD })
    @Retention(RetentionPolicy.RUNTIME)
    public @interface CustomerPersistenceService {
    }
    /** 職級データ永続化サービス */
    @Qualifier
    @Target({ ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD })
    @Retention(RetentionPolicy.RUNTIME)
    public @interface LevelPersistenceService {
    }
    /** 社員データ永続化サービス */
    @Qualifier
    @Target({ ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD })
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MemberPersistenceService {
    }
    /** 組織データ永続化サービス */
    @Qualifier
    @Target({ ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD })
    @Retention(RetentionPolicy.RUNTIME)
    public @interface OrganPersistenceService {
    }
    /** 外注データ永続化サービス */
    @Qualifier
    @Target({ ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD })
    @Retention(RetentionPolicy.RUNTIME)
    public @interface PartnerPersistenceService {
    }
    /** 調達先データ永続化サービス */
    @Qualifier
    @Target({ ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD })
    @Retention(RetentionPolicy.RUNTIME)
    public @interface SupplierPersistenceService {
    }
    /** 職名データ永続化サービス */
    @Qualifier
    @Target({ ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD })
    @Retention(RetentionPolicy.RUNTIME)
    public @interface TitlePersistenceService {
    }
}
