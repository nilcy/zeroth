// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.infra.persistence.actor;
import zeroth.actor.domain.Company;
import zeroth.framework.enterprise.domain.ConstraintsUK;
import zeroth.framework.enterprise.infra.persistence.QueryPersistenceService;
/**
 * Customer persistence I/F.
 * @param <T> company object type
 * @author nilcy
 */
public interface CompanyPersistence<T extends Company<T>> extends QueryPersistenceService<T, Long>,
    ConstraintsUK<T> {
}
