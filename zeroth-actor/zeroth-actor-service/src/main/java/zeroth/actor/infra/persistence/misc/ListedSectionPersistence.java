// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.infra.persistence.misc;
import zeroth.actor.entity.misc.ListedSection;
import zeroth.actor.infra.persistence.ConstraintsUK;
import zeroth.actor.infra.persistence.PersistenceSupport;
/**
 * Listed section persistence I/F.
 * @author nilcy
 */
public interface ListedSectionPersistence extends PersistenceSupport<ListedSection>,
    ConstraintsUK<ListedSection> {
}
