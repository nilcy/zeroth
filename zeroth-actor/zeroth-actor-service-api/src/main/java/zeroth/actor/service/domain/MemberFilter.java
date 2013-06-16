// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.domain;
import zeroth.framework.standard.shared.AbstractValueObject;
import zeroth.framework.standard.shared.PageRequest;
import zeroth.framework.standard.shared.WithPageRequest;
/**
 * 社員フィルタ
 * @author nilcy
 */
public class MemberFilter extends AbstractValueObject<MemberFilter> implements WithPageRequest {
    /** 製品番号 */
    private static final long serialVersionUID = 335281715156806802L;
    /** アカウント */
    private final String account;
    /** ページ条件 */
    private final PageRequest pageRequest;
    /**
     * コンストラクタ
     * @param account {@link #account}
     * @param pageRequest {@link #pageRequest}
     */
    public MemberFilter(final String account, final PageRequest pageRequest) {
        this.account = account;
        this.pageRequest = pageRequest;
    }
    /**
     * {@link #account} の取得
     * @return {@link #account}
     */
    public String getAccount() {
        return account;
    }
    /**
     * {@link #pageRequest} の取得
     * @return {@link #pageRequest}
     */
    @Override
    public PageRequest getPageRequest() {
        return pageRequest;
    }
}
