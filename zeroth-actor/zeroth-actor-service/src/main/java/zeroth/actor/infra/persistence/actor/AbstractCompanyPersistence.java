// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.infra.persistence.actor;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import zeroth.actor.domain.Company;
import zeroth.actor.domain.Company_;
import zeroth.framework.enterprise.domain.ConstraintsException;
/**
 * Company persistence implementation.
 * @param <T> company object type
 * @author nilcy
 */
public abstract class AbstractCompanyPersistence<T extends Company<T>> extends
    AbstractPersistenceJta<T> implements CompanyPersistence<T> {
    /** S/N. */
    private static final long serialVersionUID = -7714499275722958386L;
    /** Constructor. */
    public AbstractCompanyPersistence() {
        super();
    }
    /**
     * {@inheritDoc}
     * <ul>
     * <li>By default (aliasName asc).</li>
     * </ul>
     */
    @Override
    public void setOrdersDefault() {
        this.setOrders(new Order[] { this.asc(Company_.aliasName) });
    }
    /**
     * {@inheritDoc}
     * <ul>
     * <li>added officialName, aliasAlias, englishName, summaryName.</li>
     * </ul>
     */
    @Override
    protected Predicate createQueryPredicate(final T aEntity) {
        return this.and(super.createQueryPredicate(aEntity),
            equals(Company_.officialName, aEntity.getOfficialName()),
            equals(Company_.aliasName, aEntity.getAliasName()),
            equals(Company_.englishName, aEntity.getEnglishName()),
            equals(Company_.summaryName, aEntity.getSummaryName()));
    }
    /**
     * {@inheritDoc}
     * <ul>
     * <li>added officialName, aliasAlias, englishName, summaryName.</li>
     * </ul>
     */
    @Override
    protected Predicate createKeywordPredicate(final T aEntity) {
        if (StringUtils.isEmpty(aEntity.getKeyword())) {
            return super.createKeywordPredicate(aEntity);
        }
        return this.or(this.like(Company_.officialName, aEntity.getKeyword()),
            this.like(Company_.aliasName, aEntity.getKeyword()),
            this.like(Company_.englishName, aEntity.getKeyword()),
            this.like(Company_.summaryName, aEntity.getKeyword()));
    }
    /**
     * {@inheritDoc}
     * <ul>
     * <li>Company_UK_officialName(officialName).</li>
     * <li>Company_UK_aliasName(aliasName).</li>
     * </ul>
     */
    @Override
    public void validateUK(final T aEntity) throws ConstraintsException {
        Validate.notNull(aEntity);
        final Map<String, Object[]> causeMap = new HashMap<>();
        this.setPredicate(this.and(this.notEquals(AbstractReferenceObject_.id, aEntity.getId()),
            equals(Company_.officialName, aEntity.getOfficialName())));
        if (!this.find().isEmpty()) {
            causeMap.put("Company_UK_officialName", new Object[] { aEntity.getOfficialName() });
        }
        this.setPredicate(this.and(this.notEquals(AbstractReferenceObject_.id, aEntity.getId()),
            equals(Company_.aliasName, aEntity.getAliasName())));
        if (!this.find().isEmpty()) {
            causeMap.put("Company_UK_aliasName", new Object[] { aEntity.getAliasName() });
        }
        if (!causeMap.isEmpty()) {
            throw new ConstraintsException(causeMap);
        }
    }
}
