// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.infra.persistence.actor;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.enterprise.inject.Default;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import zeroth.actor.entity.AbstractReferenceObject_;
import zeroth.actor.entity.actor.Organ;
import zeroth.actor.entity.actor.Organ_;
import zeroth.actor.infra.persistence.AbstractPersistenceJta;
import zeroth.actor.infra.persistence.ConstraintsException;
/**
 * Organization persistence implementation.
 * @author nilcy
 */
@Default
public class OrganPersistenceImpl extends AbstractPersistenceJta<Organ> implements OrganPersistence {
    /** 製品番号 */
    private static final long serialVersionUID = 3307601051415437141L;
    /** コンストラクタ */
    public OrganPersistenceImpl() {
        super();
    }
    @Override
    public void setOrdersDefault() {
        this.setOrders(new Order[] { this.asc(Organ_.order) });
    }
    /**
     * {@inheritDoc}
     * <ul>
     * <li>added name.</li>
     * </ul>
     */
    @Override
    protected Predicate createQueryPredicate(final Organ aEntity) {
        return this.and(super.createQueryPredicate(aEntity),
            this.equals(Organ_.name, aEntity.getName()));
    }
    /**
     * {@inheritDoc}
     * <ul>
     * <li>added name.</li>
     * </ul>
     */
    @Override
    protected Predicate createKeywordPredicate(final Organ aEntity) {
        if (StringUtils.isEmpty(aEntity.getKeyword())) {
            return super.createKeywordPredicate(aEntity);
        }
        return this.or(this.like(Organ_.name, aEntity.getKeyword()));
    }
    /**
     * {@inheritDoc}
     * <ul>
     * <li>Organ_UK_name(name).</li>
     * </ul>
     */
    @Override
    public void validateUK(final Organ aEntity) throws ConstraintsException {
        Validate.notNull(aEntity);
        final Map<String, Object[]> causeMap = new HashMap<>();
        this.setPredicate(this.and(this.notEquals(AbstractReferenceObject_.id, aEntity.getId()),
            this.equals(Organ_.name, aEntity.getName())));
        if (!this.find().isEmpty()) {
            causeMap.put("Organ_UK_name", new Object[] { aEntity.getName() });
        }
        if (!causeMap.isEmpty()) {
            throw new ConstraintsException(causeMap);
        }
    }
    @Override
    public Collection<Organ> suggestParents(final Organ aTarget) {
        final Predicate hierarchicalOrder = this.lessThan(Organ_.level, aTarget.getLevel());
        this.setPredicate(hierarchicalOrder);
        return this.find();
    }
}
