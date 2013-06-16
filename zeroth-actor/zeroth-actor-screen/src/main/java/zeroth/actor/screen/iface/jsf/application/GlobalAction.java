// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.screen.iface.jsf.application;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import zeroth.actor.service.app.actor.LevelApplication;
import zeroth.actor.service.app.actor.OrganApplication;
import zeroth.actor.service.app.actor.TitleApplication;
import zeroth.actor.service.app.misc.IndustryClassApplication;
import zeroth.actor.service.app.misc.ListedSectionApplication;
import zeroth.actor.service.domain.Gender;
import zeroth.actor.service.domain.Level;
import zeroth.actor.service.domain.Organ;
import zeroth.actor.service.domain.Title;
import zeroth.actor.service.domain.misc.IndustryClass;
import zeroth.actor.service.domain.misc.ListedSection;
import zeroth.framework.screen.iface.jsf.FacesHelper;
import zeroth.framework.screen.iface.jsf.FacesProfile;
import zeroth.framework.standard.shared.FilterFactory;
/**
 * Global action.
 * @author nilcy
 */
@Named("globalAction")
@ApplicationScoped
@Singleton
// @Startup
public class GlobalAction implements Serializable {
    /** 製品番号 */
    private static final long serialVersionUID = 7243039551620767571L;
    /** industry classification service Local-I/F. */
    @EJB
    private IndustryClassApplication industryClassApplication;
    /** listed section service Local-I/F. */
    @EJB
    private ListedSectionApplication listedSectionApplication;
    /** organization service Local-I/F. */
    @EJB
    private OrganApplication organApplication;
    /** title Local-I/F. */
    @EJB
    private TitleApplication titleApplication;
    /** level Local-I/F. */
    @EJB
    private LevelApplication levelApplication;
    /** industry classification items. */
    private List<SelectItem> industryClassItems;
    /** listed section items. */
    private List<SelectItem> listedSectionItems;
    /** organization items. */
    private List<SelectItem> organItems;
    /** title items. */
    private List<SelectItem> titleItems;
    /** level items. */
    private List<SelectItem> levelItems;
    /** gender items. */
    private List<SelectItem> genderItems;
    /** コンストラクタ */
    public GlobalAction() {
        super();
    }
    /**
     * {@link #industryClassItems}.
     * @return {@link #industryClassItems}
     */
    public List<SelectItem> getIndustryClassItems() {
        if (industryClassItems == null) {
            final List<SelectItem> items = new ArrayList<>();
            for (final IndustryClass o : industryClassApplication.findMany(FilterFactory
                .createSimpleFilter())) {
                items.add(new SelectItem(o, o.getDescription()));
            }
            industryClassItems = items;
        }
        return industryClassItems;
    }
    /**
     * {@link #listedSectionItems}.
     * @return {@link #listedSectionItems}
     */
    public List<SelectItem> getListedSectionItems() {
        if (listedSectionItems == null) {
            final List<SelectItem> items = new ArrayList<>();
            for (final ListedSection o : listedSectionApplication.findMany(FilterFactory
                .createSimpleFilter())) {
                items.add(new SelectItem(o, o.getSection()));
            }
            listedSectionItems = items;
        }
        return listedSectionItems;
    }
    /**
     * {@link #organItems}.
     * @return {@link #organItems}
     */
    public List<SelectItem> getOrganItems() {
        if (organItems == null) {
            final List<SelectItem> items = new ArrayList<>();
            for (final Organ o : organApplication.findMany(FilterFactory.createSimpleFilter())) {
                items.add(new SelectItem(o, o.getName()));
            }
            organItems = items;
        }
        return organItems;
    }
    /**
     * {@link #titleItems}.
     * @return {@link #titleItems}
     */
    public List<SelectItem> getTitleItems() {
        if (titleItems == null) {
            final List<SelectItem> items = new ArrayList<>();
            for (final Title o : titleApplication.findMany(FilterFactory.createSimpleFilter())) {
                items.add(new SelectItem(o, o.getName()));
            }
            titleItems = items;
        }
        return titleItems;
    }
    /**
     * {@link #levelItems}.
     * @return {@link #levelItems}
     */
    public List<SelectItem> getLevelItems() {
        if (levelItems == null) {
            final List<SelectItem> items = new ArrayList<>();
            for (final Level o : levelApplication.findMany(FilterFactory.createSimpleFilter())) {
                items.add(new SelectItem(o, o.getName()));
            }
            levelItems = items;
        }
        return levelItems;
    }
    /**
     * {@link #genderItems}.
     * @return {@link #genderItems}
     */
    public List<SelectItem> getGenderItems() {
        if (genderItems == null) {
            final List<SelectItem> items = new ArrayList<>();
            items.add(new SelectItem(Gender.MALE, FacesHelper.getBundleMessage("Gender_MALE")));
            items.add(new SelectItem(Gender.FEMALE, FacesHelper.getBundleMessage("Gender_FEMALE")));
            genderItems = items;
        }
        return genderItems;
    }
    /**
     * default if blank.
     * @param aValue value
     * @return default if blank
     */
    @SuppressWarnings("static-method")
    public String defaultIfBlank(final String aValue) {
        return StringUtils.defaultIfBlank(aValue, FacesProfile.VIEW_NULL);
    }
    /**
     * default if empty.
     * @param aValue value
     * @return default if empty
     */
    @SuppressWarnings("static-method")
    public String defaultIfEmpty(final String aValue) {
        return StringUtils.defaultIfEmpty(aValue, FacesProfile.VIEW_NULL);
    }
    /**
     * default if null.
     * @param aValue value
     * @return default if null
     */
    @SuppressWarnings("static-method")
    public String defaultIfNull(final String aValue) {
        return ObjectUtils.defaultIfNull(aValue, FacesProfile.VIEW_NULL);
    }
}
