// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.infra.persistence.actor;
import java.util.Collection;
import zeroth.actor.entity.actor.Organ;
import zeroth.actor.infra.persistence.ConstraintsUK;
import zeroth.actor.infra.persistence.PersistenceSupport;
/**
 * Organization persistence I/F.
 * @author nilcy
 */
public interface OrganPersistence extends PersistenceSupport<Organ>, ConstraintsUK<Organ> {
    /**
     * Suggest parents.
     * @param aTarget target
     * @return parents
     */
    Collection<Organ> suggestParents(final Organ aTarget);
}
