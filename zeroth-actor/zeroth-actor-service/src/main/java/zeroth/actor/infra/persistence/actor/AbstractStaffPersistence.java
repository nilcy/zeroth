// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.infra.persistence.actor;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import org.apache.commons.lang3.StringUtils;
import zeroth.actor.entity.actor.Staff;
import zeroth.actor.entity.actor.Staff_;
import zeroth.actor.infra.persistence.AbstractPersistenceJta;
/**
 * Staff persistence implementation.
 * @param <T> staff type
 * @author nilcy
 */
public abstract class AbstractStaffPersistence<T extends Staff<T>> extends
    AbstractPersistenceJta<T> implements StaffPersistence<T> {
    /** S/N. */
    private static final long serialVersionUID = -344704859939311369L;
    /** Constructor. */
    public AbstractStaffPersistence() {
        super();
    }
    /**
     * {@inheritDoc}
     * <ul>
     * <li>by default (familyName asc, givenName asc).</li>
     * </ul>
     */
    @Override
    public void setOrdersDefault() {
        setOrders(new Order[] { asc(Staff_.familyAlias), asc(Staff_.givenAlias) });
    }
    /**
     * {@inheritDoc}
     * <ul>
     * <li>added familyName, familyAlias.</li>
     * </ul>
     */
    @Override
    protected Predicate createQueryPredicate(final T aEntity) {
        return and(super.createQueryPredicate(aEntity),
            equals(Staff_.familyName, aEntity.getFamilyName()),
            equals(Staff_.familyAlias, aEntity.getFamilyAlias()));
    }
    /**
     * {@inheritDoc}
     * <ul>
     * <li>added familyName, familyAlias.</li>
     * </ul>
     */
    @Override
    protected Predicate createKeywordPredicate(final T aEntity) {
        if (StringUtils.isEmpty(aEntity.getKeyword())) {
            return super.createKeywordPredicate(aEntity);
        }
        return or(like(Staff_.familyName, aEntity.getKeyword()),
            like(Staff_.familyAlias, aEntity.getKeyword()));
    }
}
