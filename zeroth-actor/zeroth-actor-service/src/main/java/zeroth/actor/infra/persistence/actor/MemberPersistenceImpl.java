// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.infra.persistence.actor;
import java.util.HashMap;
import java.util.Map;
import javax.enterprise.inject.Default;
import javax.persistence.criteria.Predicate;
import org.apache.commons.lang3.Validate;
import zeroth.actor.entity.AbstractReferenceObject_;
import zeroth.actor.entity.actor.Member;
import zeroth.actor.entity.actor.Member_;
import zeroth.actor.infra.persistence.ConstraintsException;
/**
 * Member persistence implementation.
 * @author nilcy
 */
@Default
public class MemberPersistenceImpl extends AbstractStaffPersistence<Member> implements
    MemberPersistence {
    /** S/N. */
    private static final long serialVersionUID = 8231055109883857841L;
    /** Constructor. */
    public MemberPersistenceImpl() {
        super();
    }
    /**
     * {@inheritDoc}
     * <ul>
     * <li>Added account.</li>
     * </ul>
     */
    @Override
    protected Predicate createQueryPredicate(final Member aEntity) {
        return this.and(super.createQueryPredicate(aEntity),
            this.equals(Member_.account, aEntity.getAccount()));
    }
    @Override
    public void validateUK(final Member aEntity) throws ConstraintsException {
        Validate.notNull(aEntity);
        final Map<String, Object[]> causeMap = new HashMap<>();
        this.setPredicate(this.and(this.notEquals(AbstractReferenceObject_.id, aEntity.getId()),
            this.equals(Member_.account, aEntity.getAccount())));
        if (!this.find().isEmpty()) {
            causeMap.put("Member_UK_account", new Object[] { aEntity.getAccount() });
        }
        if (!causeMap.isEmpty()) {
            throw new ConstraintsException(causeMap);
        }
    }
}
