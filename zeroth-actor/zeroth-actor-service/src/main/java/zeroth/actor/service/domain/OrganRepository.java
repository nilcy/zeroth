// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.domain;
import zeroth.actor.service.domain.Organ;
import zeroth.framework.enterprise.domain.SimpleRepository;
import zeroth.framework.standard.shared.SimpleFilter;
/**
 * 組織リポジトリI/F
 * @author nilcy
 */
public interface OrganRepository extends SimpleRepository<Organ, Long, SimpleFilter> {
}
