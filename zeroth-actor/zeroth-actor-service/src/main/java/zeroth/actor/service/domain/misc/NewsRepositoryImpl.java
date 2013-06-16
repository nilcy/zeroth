// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.domain.misc;
import javax.enterprise.inject.Default;
import zeroth.actor.service.domain.misc.News;
/**
 * お知らせリポジトリ
 * @author nilcy
 */
@Default
// @Tracer
public class NewsRepositoryImpl extends NoticeRepositoryImpl<News> implements NewsRepository {
    /** 製品番号 */
    private static final long serialVersionUID = 8151517797978098457L;
}
