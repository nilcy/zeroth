// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.domain.misc;
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
    /** 業種のデータ永続化サービス */
    @Qualifier
    @Target({ ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD })
    @Retention(RetentionPolicy.RUNTIME)
    public @interface IndustryClassPersistenceService {
    }
    /** 上場先のデータ永続化サービス */
    @Qualifier
    @Target({ ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD })
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ListedSectionPersistenceService {
    }
    // /** 告知のデータ永続化サービス */
    // @Qualifier
    // @Target({ ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD })
    // @Retention(RetentionPolicy.RUNTIME)
    // public @interface NoticePersistenceService {
    // }
    /** お知らせのデータ永続化サービス */
    @Qualifier
    @Target({ ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD })
    @Retention(RetentionPolicy.RUNTIME)
    public @interface NewsPersistenceService {
    }
}
