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
import zeroth.actor.entity.actor.Title;
import zeroth.actor.entity.actor.Title_;
import zeroth.actor.infra.persistence.AbstractPersistenceJta;
import zeroth.actor.infra.persistence.ConstraintsException;
/**
 * Title persistence implementation.
 * @author nilcy
 */
@Default
public class TitlePersistenceImpl extends AbstractPersistenceJta<Title> implements TitlePersistence {
    /** 製品番号 */
    private static final long serialVersionUID = 6418178537462135117L;
    /** コンストラクタ */
    public TitlePersistenceImpl() {
        super();
    }
    @Override
    public void setOrdersDefault() {
        this.setOrders(new Order[] { this.asc(Title_.order) });
    }
    /**
     * {@inheritDoc}
     * <ul>
     * <li>added name.</li>
     * </ul>
     */
    @Override
    protected Predicate createQueryPredicate(final Title aEntity) {
        return this.and(super.createQueryPredicate(aEntity),
            this.equals(Title_.name, aEntity.getName()));
    }
    /**
     * {@inheritDoc}
     * <ul>
     * <li>Level_UK_name(name).</li>
     * </ul>
     */
    @Override
    public void validateUK(final Title aEntity) throws ConstraintsException {
        Validate.notNull(aEntity);
        final Map<String, Object[]> causeMap = new HashMap<>();
        this.setPredicate(this.and(this.notEquals(AbstractReferenceObject_.id, aEntity.getId()),
            this.equals(Title_.name, aEntity.getName())));
        if (!this.find().isEmpty()) {
            causeMap.put("Title_UK_name", new Object[] { aEntity.getName() });
        }
        if (!causeMap.isEmpty()) {
            throw new ConstraintsException(causeMap);
        }
    }
}
