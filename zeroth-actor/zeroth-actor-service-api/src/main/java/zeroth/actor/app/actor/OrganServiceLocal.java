// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.app.actor;
import java.util.Collection;
import javax.ejb.Local;
import zeroth.actor.domain.Organ;
import zeroth.framework.enterprise.app.SimpleRepositoryApplication;
/**
 * Organization service Local-I/F.
 * @author nilcy
 */
@Local
public interface OrganServiceLocal extends SimpleRepositoryApplication<Organ, Long, Organ> {
    /**
     * Suggest parents.
     * @param aTarget target
     * @return parents
     */
    Collection<Organ> suggestParents(final Organ aTarget);
}
