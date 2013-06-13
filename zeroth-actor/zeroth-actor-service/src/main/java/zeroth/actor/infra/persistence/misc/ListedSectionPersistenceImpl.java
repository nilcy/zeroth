// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.infra.persistence.misc;
import java.util.HashMap;
import java.util.Map;
import javax.enterprise.inject.Default;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import org.apache.commons.lang3.Validate;
import zeroth.actor.entity.AbstractReferenceObject_;
import zeroth.actor.entity.misc.ListedSection;
import zeroth.actor.entity.misc.ListedSection_;
import zeroth.actor.infra.persistence.AbstractPersistenceJta;
import zeroth.actor.infra.persistence.ConstraintsException;
/**
 * Listed section persistence implementation.
 * @author nilcy
 */
@Default
public class ListedSectionPersistenceImpl extends AbstractPersistenceJta<ListedSection> implements
    ListedSectionPersistence {
    /** S/N. */
    private static final long serialVersionUID = -4273326519345393635L;
    /** Constructor. */
    public ListedSectionPersistenceImpl() {
        super();
    }
    @Override
    public void setOrdersDefault() {
        this.setOrders(new Order[] { this.asc(AbstractReferenceObject_.id) });
    }
    /**
     * {@inheritDoc}
     * <ul>
     * <li>added section.</li>
     * </ul>
     */
    @Override
    protected Predicate createQueryPredicate(final ListedSection aEntity) {
        return this.and(super.createQueryPredicate(aEntity),
            this.equals(ListedSection_.section, aEntity.getSection()));
    }
    @Override
    public void validateUK(final ListedSection aEntity) throws ConstraintsException {
        Validate.notNull(aEntity);
        final Map<String, Object[]> causeMap = new HashMap<>();
        this.setPredicate(this.and(this.notEquals(AbstractReferenceObject_.id, aEntity.getId()),
            this.equals(ListedSection_.section, aEntity.getSection())));
        if (!this.find().isEmpty()) {
            causeMap.put("ListedSection_UK_section", new Object[] { aEntity.getSection() });
        }
        if (!causeMap.isEmpty()) {
            throw new ConstraintsException(causeMap);
        }
    }
}
