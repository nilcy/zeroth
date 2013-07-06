// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.app.actor;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.inject.Inject;
import zeroth.actor.service.domain.Member;
import zeroth.actor.service.domain.MemberFilter;
import zeroth.actor.service.domain.MemberRepository;
import zeroth.framework.enterprise.app.AbstractSimpleRepositoryApplication;
import zeroth.framework.enterprise.domain.SimpleRepository;
import zeroth.framework.enterprise.shared.Tracer;
/**
 * 社員アプリケーション
 * @author nilcy
 */
@Stateless
// @Default
@Tracer
public class MemberApplicationImpl extends
    AbstractSimpleRepositoryApplication<Member, BigDecimal, MemberFilter> implements
    MemberApplication {
    /** 製品番号 */
    private static final long serialVersionUID = 2537651945740718957L;
    /** 社員リポジトリ */
    @Inject
    private MemberRepository repository;
    /** コンストラクタ */
    public MemberApplicationImpl() {
    }
    /** {@inheritDoc} */
    @Override
    protected SimpleRepository<Member, BigDecimal, MemberFilter> getRepository() {
        return repository;
    }
}
