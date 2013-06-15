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
import zeroth.actor.entity.actor.MemberAuth;
import zeroth.actor.entity.actor.MemberAuth_;
import zeroth.actor.infra.persistence.AbstractPersistenceJta;
import zeroth.actor.infra.persistence.ConstraintsException;
/**
 * Member authority persistence implementation.
 * @author nilcy
 */
@Default
public class MemberAuthPersistenceImpl extends AbstractPersistenceJta<MemberAuth> implements
    MemberAuthPersistence {
    /** 製品番号 */
    private static final long serialVersionUID = -3347884638019540774L;
    /** コンストラクタ */
    public MemberAuthPersistenceImpl() {
        super();
    }
    /**
     * {@inheritDoc}
     * <ul>
     * <li>Added account.</li>
     * </ul>
     */
    @Override
    protected Predicate createQueryPredicate(final MemberAuth aEntity) {
        return this.and(super.createQueryPredicate(aEntity),
            this.equals(MemberAuth_.member, aEntity.getMember()),
            this.equals(MemberAuth_.account, aEntity.getAccount()),
            this.equals(MemberAuth_.auth, aEntity.getAuth()));
    }
    @Override
    public void validateUK(final MemberAuth aEntity) throws ConstraintsException {
        Validate.notNull(aEntity);
        final Map<String, Object[]> causeMap = new HashMap<>();
        this.setPredicate(this.and(this.notEquals(AbstractReferenceObject_.id, aEntity.getId()),
            this.equals(MemberAuth_.account, aEntity.getAccount())));
        if (!this.find().isEmpty()) {
            causeMap.put("MemberAuth_UK_account", new Object[] { aEntity.getAccount() });
        }
        if (!causeMap.isEmpty()) {
            throw new ConstraintsException(causeMap);
        }
    }
}
