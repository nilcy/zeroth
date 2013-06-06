// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.shared;
/**
 * ページ条件
 * @author nilcy
 */
public class PageRequest implements Pageable {
    /** ページ番号 */
    private final int page;
    /** ページ・サイズ */
    private final int size;
    /** ソート条件 */
    private Sort sort;
    /**
     * コンストラクタ
     * @param page ページ番号
     * @param size ページサイズ
     */
    public PageRequest(final int page, final int size) {
        this.page = page;
        this.size = size;
    }
    /**
     * コンストラクタ
     * @param page ページ番号
     * @param size ページサイズ
     * @param direction ソート方向
     * @param properties ソート属性
     */
    public PageRequest(final int page, final int size, final Sort.Direction direction,
        final String... properties) {
        this.page = page;
        this.size = size;
        sort = new Sort(direction, properties);
    }
    /**
     * コンストラクタ
     * @param page ページ番号
     * @param size ページサイズ
     * @param sort ソート条件
     */
    public PageRequest(final int page, final int size, final Sort sort) {
        this.page = page;
        this.size = size;
        this.sort = sort;
    }
    /** {@inheritDoc} */
    @Override
    public int getOffset() {
        return (page - 1) * size;
    }
    /** {@inheritDoc} */
    @Override
    public int getPageNumber() {
        return page;
    }
    /** {@inheritDoc} */
    @Override
    public int getPageSize() {
        return size;
    }
    /** {@inheritDoc} */
    @Override
    public Sort getSort() {
        return sort;
    }
}
