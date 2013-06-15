// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.app.misc;
import javax.ejb.Local;
import zeroth.actor.domain.misc.IndustryClass;
import zeroth.framework.enterprise.app.SimpleRepositoryApplication;
/**
 * Industry classification service Local-I/F.
 * @author nilcy
 */
@Local
public interface IndustryClassServiceLocal extends
    SimpleRepositoryApplication<IndustryClass, Long, IndustryClass> {
}
