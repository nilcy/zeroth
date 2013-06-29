// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.shared;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import javax.cache.Cache;
import javax.cache.Cache.Entry;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.sun.appserv.web.taglibs.cache.CacheUtil;
/**
 * {@link CacheUtil} のユニットテスト
 * @author nilcy
 */
@SuppressWarnings("all")
public class CacheUtilsTest {
    private static final Logger LOG = LoggerFactory.getLogger(CacheUtilsTest.class);
    @Test
    public void testCreateAndRemove() {
        final Cache<String, Object> foo = CacheUtils.<String, Object> createCache("foo");
        assertThat(foo, is(not(nullValue())));
        foo.put("key1", Long.valueOf(1L));
        foo.put("key2", Long.valueOf(2L));
        assertThat(foo.containsKey("key1"), is(true));
        assertThat(foo.containsKey("key9"), is(false));
        for (final Entry<String, Object> entries : foo) {
            LOG.debug("key={}, value={}", entries.getKey(), entries.getValue());
        }
        foo.removeAll();
        assertThat(CacheUtils.removeCache("foo"), is(true));
    }
    @Test
    public void testGetCache() {
        final Cache<String, Object> applicationCache = CacheUtils.<String, Object> getCache();
        assertThat(applicationCache, is(not(nullValue())));
        applicationCache.put("key1", Long.valueOf(1L));
        applicationCache.put("key2", Long.valueOf(2L));
        assertThat(applicationCache.containsKey("key1"), is(true));
        assertThat(applicationCache.containsKey("key9"), is(false));
        for (final Entry<String, Object> entries : applicationCache) {
            LOG.debug("key={}, value={}", entries.getKey(), entries.getValue());
        }
    }
}
