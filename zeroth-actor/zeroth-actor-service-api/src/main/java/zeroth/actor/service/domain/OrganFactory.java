// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.domain;
import zeroth.framework.standard.shared.AbstractFactory;
/**
 * Organization factory.
 * @author nilcy
 */
public class OrganFactory extends AbstractFactory<Organ> {
    /** コンストラクタ */
    public OrganFactory() {
        super();
    }
    /**
     * Create instance.
     * @see AbstractFactory#create()
     * @param aName organization name
     * @return created instance
     */
    public Organ create(final String aName) {
        final Organ i = super.create();
        i.setName(aName);
        return i;
    }
    /**
     * Create instance.
     * @see #create(String)
     * @param aName organization name
     * @param aHierarchicalOrder hierarchical order
     * @param aAdministrativeOrder administrative order
     * @return created instance
     */
    public Organ create(final String aName, final Long aHierarchicalOrder,
        final Long aAdministrativeOrder) {
        final Organ i = create(aName);
        i.setLevel(aHierarchicalOrder);
        i.setOrder(aAdministrativeOrder);
        return i;
    }
    /**
     * Create instance.
     * @see #create(String, Long, Long)
     * @param aName organization name
     * @param aLevel hierarchy level
     * @param aAdminOrder administrative order
     * @param aParent parent organization
     * @return created instance
     */
    public Organ create(final String aName, final Long aLevel, final Long aAdminOrder,
        final Organ aParent) {
        final Organ i = create(aName, aLevel, aAdminOrder);
        i.setParent(aParent);
        return i;
    }
}
