// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.app.actor;
import javax.ejb.Local;
import zeroth.actor.domain.Title;
import zeroth.framework.enterprise.app.SimpleRepositoryService;
/**
 * Title service Local-I/F.
 * @author nilcy
 */
@Local
public interface TitleServiceLocal extends SimpleRepositoryService<Title, Long, Title> {
}
