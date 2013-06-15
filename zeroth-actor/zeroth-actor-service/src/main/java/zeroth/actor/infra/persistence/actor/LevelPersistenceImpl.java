// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.infra.persistence.actor;
import java.util.HashMap;
import java.util.Map;
import javax.enterprise.inject.Default;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import org.apache.commons.lang3.Validate;
import zeroth.actor.entity.AbstractReferenceObject_;
import zeroth.actor.entity.actor.Level;
import zeroth.actor.entity.actor.Level_;
import zeroth.actor.infra.persistence.AbstractPersistenceJta;
import zeroth.actor.infra.persistence.ConstraintsException;
/**
 * Level persistence implementation.
 * @author nilcy
 */
@Default
public class LevelPersistenceImpl extends AbstractPersistenceJta<Level> implements LevelPersistence {
    /** 製品番号 */
    private static final long serialVersionUID = -6479710336837000717L;
    /** コンストラクタ */
    public LevelPersistenceImpl() {
        super();
    }
    @Override
    public void setOrdersDefault() {
        this.setOrders(new Order[] { this.asc(Level_.rank) });
    }
    /**
     * {@inheritDoc}
     * <ul>
     * <li>added name.</li>
     * </ul>
     */
    @Override
    protected Predicate createQueryPredicate(final Level aEntity) {
        return this.and(super.createQueryPredicate(aEntity),
            this.equals(Level_.name, aEntity.getName()));
    }
    /**
     * {@inheritDoc}
     * <ul>
     * <li>Level_UK_name(name).</li>
     * </ul>
     */
    @Override
    public void validateUK(final Level aEntity) throws ConstraintsException {
        Validate.notNull(aEntity);
        final Map<String, Object[]> causeMap = new HashMap<>();
        this.setPredicate(this.and(this.notEquals(AbstractReferenceObject_.id, aEntity.getId()),
            this.equals(Level_.name, aEntity.getName())));
        if (!this.find().isEmpty()) {
            causeMap.put("Level_UK_name", new Object[] { aEntity.getName() });
        }
        if (!causeMap.isEmpty()) {
            throw new ConstraintsException(causeMap);
        }
    }
}
