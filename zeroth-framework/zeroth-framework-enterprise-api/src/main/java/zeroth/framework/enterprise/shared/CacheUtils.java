// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.enterprise.shared;
import javax.cache.Cache;
import javax.cache.CacheBuilder;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.transaction.IsolationLevel;
import javax.cache.transaction.Mode;
/**
 * キャッシュのユーティリティ
 * @author nilcy
 */
public final class CacheUtils {
    /** キャッシュマネージャ */
    private static final CacheManager MANAGER = Caching.getCacheManager();
    /** 非公開コンストラクタ */
    private CacheUtils() {
    }
    /**
     * キャッシュの作成
     * <p>
     * 最後に {@link CacheUtils#removeCache(String)} を実行すること。
     * </p>
     * @param <K> キーオブジェクト型
     * @param <V> バリューオブジェクト型
     * @param cacheName キャッシュ名
     * @return cache キャッシュ
     * @see javax.cache.Cache
     */
    public static <K, V> Cache<K, V> createCache(final String cacheName) {
        final CacheBuilder<K, V> builder = MANAGER.createCacheBuilder(cacheName);
        builder.setStoreByValue(true);
        builder.setStatisticsEnabled(true);
        return builder.build();
    }
    /**
     * キャッシュの取得
     * @param <K> キーオブジェクト型
     * @param <V> バリューオブジェクト型
     * @param cacheName キャッシュ名
     * @return cache キャッシュ
     * @see javax.cache.Cache
     */
    public static <K, V> Cache<K, V> getCache(final String cacheName) {
        return MANAGER.getCache(cacheName);
    }
    /**
     * デフォルトキャッシュの取得
     * @param <K> キーオブジェクト型
     * @param <V> バリューオブジェクト型
     * @return cache キャッシュ
     * @see javax.cache.Cache
     */
    public static <K, V> Cache<K, V> getCache() {
        return getCache("application");
    }
    /**
     * キャッシュの削除
     * @param aCacheName キャッシュ名
     * @return キャッシュ削除の成否
     * @see javax.cache.CacheManager#removeCache(String)
     */
    public static boolean removeCache(final String aCacheName) {
        return MANAGER.removeCache(aCacheName);
    }
    /**
     * 読込専用キャッシュの作成
     * @param <K> キーオブジェクト型
     * @param <V> バリューオブジェクト型
     * @param cacheName キャッシュ名
     * @return cache キャッシュ
     * @see javax.cache.Cache
     */
    public static <K, V> Cache<K, V> createReadCache(final String cacheName) {
        final CacheBuilder<K, V> builder = MANAGER.createCacheBuilder(cacheName);
        builder.setStatisticsEnabled(true);
        builder.setReadThrough(true);
        builder.setWriteThrough(false);
        builder.setTransactionEnabled(IsolationLevel.READ_COMMITTED, Mode.LOCAL);
        return builder.build();
    }
}
