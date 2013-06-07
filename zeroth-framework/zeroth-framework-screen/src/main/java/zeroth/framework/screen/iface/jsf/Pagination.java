// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.screen.iface.jsf;
import java.util.Collection;
/**
 * Pagination I/F.
 * @param <T> entity type.
 * @author nilcy
 */
public interface Pagination<T> {
    /**
     * Create collection.
     * @return collection
     */
    Collection<T> createCollection();
    /**
     * Get items count.
     * @return items count
     */
    int getItemsCount();
    /**
     * Get first index.
     * @return first index
     */
    int getFirstIndex();
    /**
     * Get last index.
     * @return last index
     */
    int getLastIndex();
    /**
     * Get page size.
     * @return page size
     */
    int getPageSize();
    /**
     * Determine if has next page.
     * @return true if has next page
     */
    boolean isHasNext();
    /**
     * Determine if has previous page.
     * @return true if has previous page
     */
    boolean isHasPrev();
    // /** Next page. */
    // void nextPage();
    // /** Previous page. */
    // void prevPage();
}
