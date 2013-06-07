// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.screen.iface.jsf;
import java.util.Collection;
/**
 * Pagination implementation.
 * @param <T> entity type
 * @author nilcy
 */
abstract class AbstractPagination<T> implements Pagination<T> {
    /** page size. */
    private final int pageSize;
    /** current page. */
    private final int page;
    /**
     * Constructor.
     * @param aPageSize {@link #pageSize}
     * @param aPage {@link #page}
     */
    public AbstractPagination(final int aPageSize, final int aPage) {
        this.pageSize = aPageSize;
        this.page = aPage;
    }
    @Override
    public abstract Collection<T> createCollection();
    @Override
    public abstract int getItemsCount();
    /**
     * {@inheritDoc}
     * @return {@link #page} * {@link #pageSize}
     */
    @Override
    public int getFirstIndex() {
        return this.page * this.pageSize;
    }
    /**
     * {@inheritDoc}
     * @return {@link #getFirstIndex()} + {@link #pageSize} -1
     */
    @Override
    public int getLastIndex() {
        int i = (getFirstIndex() + this.pageSize) - 1;
        final int count = getItemsCount() - 1;
        if (i > count) {
            i = count;
        } else if (i < 0) {
            i = 0;
        }
        return i;
    }
    /**
     * {@inheritDoc}
     * @return {@link #pageSize}
     */
    @Override
    public int getPageSize() {
        return this.pageSize;
    }
    /**
     * {@inheritDoc}
     * @return true if ((({@link #page} + 1) * {@link #pageSize}) + 1)
     *         <= {@link #getItemsCount}()
     */
    @Override
    public boolean isHasNext() {
        return (((this.page + 1) * this.pageSize) + 1) <= getItemsCount();
    }
    /**
     * {@inheritDoc}
     * @return true if {@link #page} > 0
     */
    @Override
    public boolean isHasPrev() {
        return this.page > 0;
    }
    // /**
    // * {@inheritDoc} {@link #page} += 1.
    // */
    // @Override
    // public void nextPage() {
    // if (isHasNext()) {
    // this.page += 1;
    // }
    // }
    // /** {@inheritDoc} {@link #page} -= 1. */
    // @Override
    // public void prevPage() {
    // if (isHasPrev()) {
    // this.page -= 1;
    // }
    // }
}
