// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.shared;
import java.util.logging.Logger;
import net.sf.ehcache.Status;
import net.sf.ehcache.event.CacheManagerEventListener;
/**
 * キャッシュマネージャのイベントリスナー
 * @author nilcy
 */
public final class DefaultCacheManagerEventListener implements CacheManagerEventListener {
    /** ロガー */
    private static final Logger LOG = Logger.getAnonymousLogger();
    /** コンストラクタ */
    public DefaultCacheManagerEventListener() {
    }
    /** {@inheritDoc} */
    @Override
    public void init() {
        LOG.fine("initialized");
    }
    /** {@inheritDoc} */
    @Override
    public Status getStatus() {
        return null;
    }
    /** {@inheritDoc} */
    @Override
    public void dispose() {
        LOG.fine("disposed");
    }
    /** {@inheritDoc} */
    @Override
    public void notifyCacheAdded(final String cacheName) {
        LOG.fine("added cache " + cacheName);
    }
    /** {@inheritDoc} */
    @Override
    public void notifyCacheRemoved(final String cacheName) {
        LOG.fine("removed cache " + cacheName);
    }
}
