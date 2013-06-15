// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.app.misc;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import zeroth.actor.app.AbstractCrudService;
import zeroth.actor.common.TraceLog;
import zeroth.actor.domain.Repository;
import zeroth.actor.domain.misc.IndustryClassRepository;
import zeroth.actor.entity.misc.IndustryClass;
/**
 * Industry classification service implementation.
 * @author nilcy
 */
@Stateless
@Default
@TraceLog
public class IndustryClassServiceImpl extends AbstractCrudService<IndustryClass> implements
    IndustryClassServiceLocal {
    /** 製品番号 */
    private static final long serialVersionUID = 2537651945740718957L;
    /** organization repository I/F. */
    @Inject
    private IndustryClassRepository repository;
    /** コンストラクタ */
    public IndustryClassServiceImpl() {
        super();
    }
    /**
     * {@inheritDoc} Get {@link #repository}.
     */
    @Override
    protected Repository<IndustryClass> getRepository() {
        return this.repository;
    }
}
