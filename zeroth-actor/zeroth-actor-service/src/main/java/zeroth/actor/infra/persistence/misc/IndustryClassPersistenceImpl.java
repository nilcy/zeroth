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
import zeroth.actor.entity.misc.IndustryClass;
import zeroth.actor.entity.misc.IndustryClass_;
import zeroth.actor.infra.persistence.AbstractPersistenceJta;
import zeroth.actor.infra.persistence.ConstraintsException;
/**
 * Industry classification persistence implementation.
 * @author nilcy
 */
@Default
public class IndustryClassPersistenceImpl extends AbstractPersistenceJta<IndustryClass> implements
    IndustryClassPersistence {
    /** 製品番号 */
    private static final long serialVersionUID = 7089621081283633688L;
    /** コンストラクタ */
    public IndustryClassPersistenceImpl() {
        super();
    }
    @Override
    public void setOrdersDefault() {
        this.setOrders(new Order[] { this.asc(IndustryClass_.sector) });
    }
    /**
     * {@inheritDoc}
     * <ul>
     * <li>added sector, description.</li>
     * </ul>
     */
    @Override
    protected Predicate createQueryPredicate(final IndustryClass aEntity) {
        return this.and(super.createQueryPredicate(aEntity),
            this.equals(IndustryClass_.sector, aEntity.getSector()),
            this.equals(IndustryClass_.description, aEntity.getDescription()));
    }
    /**
     * {@inheritDoc}
     * <ul>
     * <li>Level_UK_name(name).</li>
     * </ul>
     */
    @Override
    public void validateUK(final IndustryClass aEntity) throws ConstraintsException {
        Validate.notNull(aEntity);
        final Map<String, Object[]> causeMap = new HashMap<>();
        this.setPredicate(this.and(this.notEquals(AbstractReferenceObject_.id, aEntity.getId()),
            this.equals(IndustryClass_.sector, aEntity.getSector())));
        if (!this.find().isEmpty()) {
            causeMap.put("IndustryClass_UK_sector", new Object[] { aEntity.getSector() });
        }
        this.setPredicate(this.and(this.notEquals(AbstractReferenceObject_.id, aEntity.getId()),
            this.equals(IndustryClass_.description, aEntity.getDescription())));
        if (!this.find().isEmpty()) {
            causeMap.put("IndustryClass_UK_description", new Object[] { aEntity.getDescription() });
        }
        if (!causeMap.isEmpty()) {
            throw new ConstraintsException(causeMap);
        }
    }
}
