// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.infra.persistence.actor;
import zeroth.actor.entity.actor.Staff;
import zeroth.actor.infra.persistence.PersistenceSupport;
/**
 * Staff persistence I/F.
 * @param <T> staff type
 * @author nilcy
 */
public interface StaffPersistence<T extends Staff<T>> extends PersistenceSupport<T> {
}
