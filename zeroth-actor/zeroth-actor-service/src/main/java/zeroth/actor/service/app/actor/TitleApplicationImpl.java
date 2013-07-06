// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.app.actor;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.inject.Inject;
import zeroth.actor.service.domain.Title;
import zeroth.actor.service.domain.TitleRepository;
import zeroth.framework.enterprise.app.AbstractSimpleRepositoryApplication;
import zeroth.framework.enterprise.domain.SimpleRepository;
import zeroth.framework.enterprise.shared.Tracer;
import zeroth.framework.standard.shared.SimpleFilter;
/**
 * 職名アプリケーション
 * @author nilcy
 */
@Stateless
// @Default
@Tracer
public class TitleApplicationImpl extends
    AbstractSimpleRepositoryApplication<Title, BigDecimal, SimpleFilter> implements
    TitleApplication {
    /** 製品番号 */
    private static final long serialVersionUID = -2055548765950043371L;
    /** 職名リポジトリ */
    @Inject
    private TitleRepository repository;
    /** コンストラクタ */
    public TitleApplicationImpl() {
    }
    /** {@inheritDoc} */
    @Override
    protected SimpleRepository<Title, BigDecimal, SimpleFilter> getRepository() {
        return repository;
    }
}
