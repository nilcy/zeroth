// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.infra.persistence.misc;
import javax.enterprise.inject.Default;
import zeroth.actor.entity.misc.News;
/**
 * News persistence implementation.
 * @author nilcy
 */
@Default
public class NewsPersistenceImpl extends AbstractNoticePersistence<News> implements NewsPersistence {
    /** 製品番号 */
    private static final long serialVersionUID = 6636565061976375548L;
    /** コンストラクタ */
    public NewsPersistenceImpl() {
        super();
    }
}
