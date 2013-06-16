// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.app.actor;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import zeroth.actor.service.app.actor.MemberApplication;
import zeroth.actor.service.domain.Member;
import zeroth.actor.service.domain.MemberRepository;
import zeroth.framework.enterprise.app.AbstractSimpleRepositoryApplication;
import zeroth.framework.enterprise.domain.SimpleRepository;
import zeroth.framework.enterprise.shared.Tracer;
import zeroth.framework.standard.shared.SimpleFilter;
/**
 * 社員アプリケーション
 * @author nilcy
 */
@Stateless
@Default
@Tracer
public class MemberApplicationImpl extends
    AbstractSimpleRepositoryApplication<Member, Long, SimpleFilter> implements MemberApplication {
    /** 製品番号 */
    private static final long serialVersionUID = 2537651945740718957L;
    /** 社員リポジトリ */
    @Inject
    private MemberRepository repository;
    /** {@inheritDoc} */
    @Override
    protected SimpleRepository<Member, Long, SimpleFilter> getRepository() {
        return repository;
    }
}
