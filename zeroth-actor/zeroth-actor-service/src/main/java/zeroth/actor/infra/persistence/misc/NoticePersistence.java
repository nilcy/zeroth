// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.infra.persistence.misc;
import zeroth.actor.entity.misc.Notice;
import zeroth.actor.infra.persistence.PersistenceSupport;
/**
 * Notice persistence I/F.
 * @param <T> entity type
 * @author nilcy
 */
public interface NoticePersistence<T extends Notice<T>> extends PersistenceSupport<T> {
}
