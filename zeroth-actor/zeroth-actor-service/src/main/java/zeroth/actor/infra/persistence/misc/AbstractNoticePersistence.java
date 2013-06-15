// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.infra.persistence.misc;
import javax.persistence.criteria.Predicate;
import org.apache.commons.lang3.StringUtils;
import zeroth.actor.entity.misc.Notice;
import zeroth.actor.entity.misc.Notice_;
import zeroth.actor.infra.persistence.AbstractPersistenceJta;
/**
 * Notice persistence implementation.
 * @param <T> entity type
 * @author nilcy
 */
public abstract class AbstractNoticePersistence<T extends Notice<T>> extends
    AbstractPersistenceJta<T> implements NoticePersistence<T> {
    /** 製品番号 */
    private static final long serialVersionUID = -932535992210987810L;
    /** コンストラクタ */
    public AbstractNoticePersistence() {
        super();
    }
    /**
     * {@inheritDoc}
     * <ul>
     * <li>added title, description, category.</li>
     * </ul>
     */
    @Override
    protected Predicate createQueryPredicate(final T aEntity) {
        return and(super.createQueryPredicate(aEntity), equals(Notice_.title, aEntity.getTitle()),
            equals(Notice_.description, aEntity.getTitle()),
            equals(Notice_.category, aEntity.getTitle()));
    }
    /**
     * {@inheritDoc}
     * <ul>
     * <li>added title, description, category.</li>
     * </ul>
     */
    @Override
    protected Predicate createKeywordPredicate(final T aEntity) {
        if (StringUtils.isEmpty(aEntity.getKeyword())) {
            return super.createKeywordPredicate(aEntity);
        }
        return or(like(Notice_.title, aEntity.getKeyword()),
            like(Notice_.description, aEntity.getKeyword()),
            like(Notice_.category, aEntity.getCategory()));
    }
}
