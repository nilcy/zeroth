// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.domain;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import zeroth.actor.common.TraceLog;
import zeroth.actor.domain.AbstractCrudRepository;
import zeroth.actor.entity.actor.Member;
import zeroth.actor.infra.persistence.PersistenceSupport;
import zeroth.actor.infra.persistence.actor.MemberPersistence;
/**
 * Member repository implementation.
 * @author nilcy
 */
@Default
@TraceLog
public class MemberRepositoryImpl extends AbstractCrudRepository<Member> implements
    MemberRepository {
    /** 製品番号 */
    private static final long serialVersionUID = 2537651945740718957L;
    /** member persistence I/F. */
    @Inject
    private MemberPersistence persistence;
    /** コンストラクタ */
    public MemberRepositoryImpl() {
        super();
    }
    /**
     * {@inheritDoc} Get {@link #persistence}.
     * @return {@inheritDoc}
     */
    @Override
    public PersistenceSupport<Member> getPersistenceSupport() {
        return this.persistence;
    }
}
