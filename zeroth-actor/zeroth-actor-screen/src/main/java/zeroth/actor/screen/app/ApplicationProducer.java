// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.screen.app;
import javax.ejb.EJB;
import javax.enterprise.inject.Produces;
import zeroth.actor.screen.app.ApplicationAnnotation.CustomerApplicationCDI;
import zeroth.actor.screen.app.ApplicationAnnotation.IndustryClassApplicationCDI;
import zeroth.actor.screen.app.ApplicationAnnotation.LevelApplicationCDI;
import zeroth.actor.screen.app.ApplicationAnnotation.ListedSectionApplicationCDI;
import zeroth.actor.screen.app.ApplicationAnnotation.MemberApplicationCDI;
import zeroth.actor.screen.app.ApplicationAnnotation.NewsApplicationCDI;
import zeroth.actor.screen.app.ApplicationAnnotation.OrganApplicationCDI;
import zeroth.actor.screen.app.ApplicationAnnotation.PartnerApplicationCDI;
import zeroth.actor.screen.app.ApplicationAnnotation.SupplierApplicationCDI;
import zeroth.actor.screen.app.ApplicationAnnotation.TitleApplicationCDI;
import zeroth.actor.service.app.actor.CustomerApplication;
import zeroth.actor.service.app.actor.LevelApplication;
import zeroth.actor.service.app.actor.MemberApplication;
import zeroth.actor.service.app.actor.OrganApplication;
import zeroth.actor.service.app.actor.PartnerApplication;
import zeroth.actor.service.app.actor.SupplierApplication;
import zeroth.actor.service.app.actor.TitleApplication;
import zeroth.actor.service.app.misc.IndustryClassApplication;
import zeroth.actor.service.app.misc.ListedSectionApplication;
import zeroth.actor.service.app.misc.NewsApplication;
/**
 * 関係先アプリケーションのプロデューサ
 * @author nilcy
 */
public class ApplicationProducer {
    /** 得意先アプリケーションI/F */
    @EJB
    @Produces
    @CustomerApplicationCDI
    private CustomerApplication CustomerApplication;
    /** 職級アプリケーションI/F */
    @EJB
    @Produces
    @LevelApplicationCDI
    private LevelApplication LevelApplication;
    /** 社員アプリケーションI/F */
    @EJB
    @Produces
    @MemberApplicationCDI
    private MemberApplication MemberApplication;
    /** 組織アプリケーションI/F */
    @EJB
    @Produces
    @OrganApplicationCDI
    private OrganApplication OrganApplication;
    /** 外注アプリケーションI/F */
    @EJB
    @Produces
    @PartnerApplicationCDI
    private PartnerApplication PartnerApplication;
    /** 調達先アプリケーションI/F */
    @EJB
    @Produces
    @SupplierApplicationCDI
    private SupplierApplication SupplierApplication;
    /** 職名アプリケーションI/F */
    @EJB
    @Produces
    @TitleApplicationCDI
    private TitleApplication TitleApplication;
    /** 上場先アプリケーションI/F */
    @EJB
    @Produces
    @ListedSectionApplicationCDI
    private ListedSectionApplication ListedSectionApplication;
    /** お知らせアプリケーションI/F */
    @EJB
    @Produces
    @NewsApplicationCDI
    private NewsApplication NewsApplication;
    /** 業種アプリケーションI/F */
    @EJB
    @Produces
    @IndustryClassApplicationCDI
    private IndustryClassApplication IndustryClassApplication;
}
