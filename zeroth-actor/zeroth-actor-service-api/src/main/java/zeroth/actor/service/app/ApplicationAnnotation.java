// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.app;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.inject.Qualifier;
/**
 * 関係先アプリケーションのCDIアノテーション
 * @author nilcy
 */
public @interface ApplicationAnnotation {
    /** 得意先アプリケーション */
    @Qualifier
    @Target({ ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD })
    @Retention(RetentionPolicy.RUNTIME)
    public @interface CustomerApplicationCDI {
    }
    /** 職級アプリケーション */
    @Qualifier
    @Target({ ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD })
    @Retention(RetentionPolicy.RUNTIME)
    public @interface LevelApplicationCDI {
    }
    /** 社員アプリケーション */
    @Qualifier
    @Target({ ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD })
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MemberApplicationCDI {
    }
    /** 組織アプリケーション */
    @Qualifier
    @Target({ ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD })
    @Retention(RetentionPolicy.RUNTIME)
    public @interface OrganApplicationCDI {
    }
    /** 外注アプリケーション */
    @Qualifier
    @Target({ ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD })
    @Retention(RetentionPolicy.RUNTIME)
    public @interface PartnerApplicationCDI {
    }
    /** 調達先アプリケーション */
    @Qualifier
    @Target({ ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD })
    @Retention(RetentionPolicy.RUNTIME)
    public @interface SupplierApplicationCDI {
    }
    /** 職名アプリケーション */
    @Qualifier
    @Target({ ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD })
    @Retention(RetentionPolicy.RUNTIME)
    public @interface TitleApplicationCDI {
    }
    /** 業種アプリケーション */
    @Qualifier
    @Target({ ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD })
    @Retention(RetentionPolicy.RUNTIME)
    public @interface IndustryClassApplicationCDI {
    }
    /** 上場先アプリケーション */
    @Qualifier
    @Target({ ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD })
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ListedSectionApplicationCDI {
    }
    /** お知らせアプリケーション */
    @Qualifier
    @Target({ ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD })
    @Retention(RetentionPolicy.RUNTIME)
    public @interface NewsApplicationCDI {
    }
}
