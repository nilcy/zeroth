// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.domain;
import zeroth.framework.standard.shared.FilterFactory;
import zeroth.framework.standard.shared.PageRequest;
/**
 * フィルタのファクトリ
 * @author nilcy
 */
public class ActorFilterFactory extends FilterFactory {
    /**
     * 社員フィルタの生成
     * <dl>
     * <dt>事前条件</dt>
     * <dd>アカウントは非NULLであること。</dd>
     * <dt>事後条件</dt>
     * <dd>ページ条件がデフォルトの基本フィルタを生成する。</dd>
     * </dl>
     * @param account アカウント
     * @return 社員フィルタ
     */
    public static MemberFilter createMemberFilter(final String account) {
        assert account != null;
        return new MemberFilter(account, new PageRequest(DEFAULT_PAGE, DEFAULT_SIZE));
    }
}
