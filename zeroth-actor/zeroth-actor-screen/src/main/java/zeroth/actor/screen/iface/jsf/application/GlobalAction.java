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
import com.kuzumeji.domain.actor.LevelFactory;
import com.kuzumeji.domain.actor.OrganFactory;
import com.kuzumeji.domain.actor.TitleFactory;
import com.kuzumeji.domain.misc.IndustryClassFactory;
import com.kuzumeji.domain.misc.ListedSectionFactory;
import com.kuzumeji.entity.actor.Gender;
import com.kuzumeji.entity.actor.Level;
import com.kuzumeji.entity.actor.Organ;
import com.kuzumeji.entity.actor.Title;
import com.kuzumeji.entity.misc.IndustryClass;
import com.kuzumeji.entity.misc.ListedSection;
import zeroth.actor.screen.iface.jsf.FacesHelper;
import zeroth.actor.screen.iface.jsf.FacesProfile;
import zeroth.framework.enterprise.app.actor.LevelServiceLocal;
import zeroth.framework.enterprise.app.actor.OrganServiceLocal;
import zeroth.framework.enterprise.app.actor.TitleServiceLocal;
import zeroth.framework.enterprise.app.misc.IndustryClassServiceLocal;
import zeroth.framework.enterprise.app.misc.ListedSectionServiceLocal;
/**
 * Global action.
 * @author nilcy
 */
@Named("globalAction")
@ApplicationScoped
@Singleton
// @Startup
public class GlobalAction implements Serializable {
    /** S/N. */
    private static final long serialVersionUID = 7243039551620767571L;
    /** industry classification service Local-I/F. */
    @EJB
    private IndustryClassServiceLocal industryClassService;
    /** listed section service Local-I/F. */
    @EJB
    private ListedSectionServiceLocal listedSectionService;
    /** organization service Local-I/F. */
    @EJB
    private OrganServiceLocal organService;
    /** title Local-I/F. */
    @EJB
    private TitleServiceLocal titleService;
    /** level Local-I/F. */
    @EJB
    private LevelServiceLocal levelService;
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
    /** Constructor. */
    public GlobalAction() {
        super();
    }
    /**
     * Get {@link #industryClassItems}.
     * @return {@link #industryClassItems}
     */
    public List<SelectItem> getIndustryClassItems() {
        if (this.industryClassItems == null) {
            final List<SelectItem> items = new ArrayList<>();
            for (final IndustryClass o : this.industryClassService.find(new IndustryClassFactory()
                .create())) {
                items.add(new SelectItem(o, o.getDescription()));
            }
            this.industryClassItems = items;
        }
        return this.industryClassItems;
    }
    /**
     * Get {@link #listedSectionItems}.
     * @return {@link #listedSectionItems}
     */
    public List<SelectItem> getListedSectionItems() {
        if (this.listedSectionItems == null) {
            final List<SelectItem> items = new ArrayList<>();
            for (final ListedSection o : this.listedSectionService.find(new ListedSectionFactory()
                .create())) {
                items.add(new SelectItem(o, o.getSection()));
            }
            this.listedSectionItems = items;
        }
        return this.listedSectionItems;
    }
    /**
     * Get {@link #organItems}.
     * @return {@link #organItems}
     */
    public List<SelectItem> getOrganItems() {
        if (this.organItems == null) {
            final List<SelectItem> items = new ArrayList<>();
            for (final Organ o : this.organService.find(new OrganFactory().create())) {
                items.add(new SelectItem(o, o.getName()));
            }
            this.organItems = items;
        }
        return this.organItems;
    }
    /**
     * Get {@link #titleItems}.
     * @return {@link #titleItems}
     */
    public List<SelectItem> getTitleItems() {
        if (this.titleItems == null) {
            final List<SelectItem> items = new ArrayList<>();
            for (final Title o : this.titleService.find(new TitleFactory().create())) {
                items.add(new SelectItem(o, o.getName()));
            }
            this.titleItems = items;
        }
        return this.titleItems;
    }
    /**
     * Get {@link #levelItems}.
     * @return {@link #levelItems}
     */
    public List<SelectItem> getLevelItems() {
        if (this.levelItems == null) {
            final List<SelectItem> items = new ArrayList<>();
            for (final Level o : this.levelService.find(new LevelFactory().create())) {
                items.add(new SelectItem(o, o.getName()));
            }
            this.levelItems = items;
        }
        return this.levelItems;
    }
    /**
     * Get {@link #genderItems}.
     * @return {@link #genderItems}
     */
    public List<SelectItem> getGenderItems() {
        if (this.genderItems == null) {
            final List<SelectItem> items = new ArrayList<>();
            items.add(new SelectItem(Gender.MALE, FacesHelper.getBundleMessage("Gender_MALE")));
            items.add(new SelectItem(Gender.FEMALE, FacesHelper.getBundleMessage("Gender_FEMALE")));
            this.genderItems = items;
        }
        return this.genderItems;
    }
    /**
     * Get default if blank.
     * @param aValue value
     * @return default if blank
     */
    @SuppressWarnings("static-method")
    public String defaultIfBlank(final String aValue) {
        return StringUtils.defaultIfBlank(aValue, FacesProfile.VIEW_NULL);
    }
    /**
     * Get default if empty.
     * @param aValue value
     * @return default if empty
     */
    @SuppressWarnings("static-method")
    public String defaultIfEmpty(final String aValue) {
        return StringUtils.defaultIfEmpty(aValue, FacesProfile.VIEW_NULL);
    }
    /**
     * Get default if null.
     * @param aValue value
     * @return default if null
     */
    @SuppressWarnings("static-method")
    public String defaultIfNull(final String aValue) {
        return ObjectUtils.defaultIfNull(aValue, FacesProfile.VIEW_NULL);
    }
}
