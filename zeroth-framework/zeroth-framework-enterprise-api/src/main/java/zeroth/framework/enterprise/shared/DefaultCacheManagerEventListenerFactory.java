// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.shared;
import java.util.Properties;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.event.CacheManagerEventListener;
/**
 * キャッシュマネージャのイベントリスナーのファクトリー
 * @author nilcy
 */
public final class DefaultCacheManagerEventListenerFactory extends
    net.sf.ehcache.event.CacheManagerEventListenerFactory {
    /** コンストラクタ */
    public DefaultCacheManagerEventListenerFactory() {
    }
    /** {@inheritDoc} */
    @Override
    public CacheManagerEventListener createCacheManagerEventListener(
        final CacheManager cacheManager, final Properties properties) {
        return new DefaultCacheManagerEventListener();
    }
}
