// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.domain.actor;
import java.util.Collection;
import zeroth.actor.domain.CrudRepository;
import zeroth.actor.entity.actor.Organ;
/**
 * Organization repository I/F.
 * @author nilcy
 */
public interface OrganRepository extends CrudRepository<Organ> {
    /**
     * Suggest parents.
     * @param aTarget target
     * @return parents
     */
    Collection<Organ> suggestParents(final Organ aTarget);
}
