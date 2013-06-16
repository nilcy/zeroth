// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.actor.service.domain.misc;
import java.util.logging.Logger;
import javax.inject.Inject;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.googlecode.jeeunit.JeeunitRunner;
import com.googlecode.jeeunit.Transactional;
import zeroth.actor.service.domain.misc.News;
import zeroth.actor.service.domain.misc.NewsRepository;
import zeroth.actor.service.domain.misc.NewsRepositoryImpl;
import zeroth.framework.enterprise.domain.ConstraintsException;
/**
 * {@link NewsRepositoryImpl} のユニットテスト
 * @author nilcy
 */
@RunWith(JeeunitRunner.class)
@Transactional
@SuppressWarnings("all")
public class NewsRepositoryImplTest {
    @Inject
    private NewsRepository testee;
    @Inject
    private Logger log;
    @Test
    public final void test() throws ConstraintsException {
        testee.save(new News());
    }
}
