// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.standard.shared;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
/**
 * ソート条件
 * @author nilcy
 */
public class Sort implements Serializable {
    /** 製品番号 */
    private static final long serialVersionUID = -8912988220137446490L;
    /** ソート条件 */
    private final Order[] orders;
    /**
     * コンストラクタ
     * @param orders ソート条件
     */
    public Sort(final Collection<Order> orders) {
        this.orders = orders.toArray(new Order[0]);
    }
    /**
     * コンストラクタ
     * @param orders ソート条件
     */
    public Sort(final Order... orders) {
        this.orders = orders;
    }
    /**
     * コンストラクタ
     * @param direction ソート方向
     * @param properties ソート属性
     */
    public Sort(final Direction direction, final Collection<String> properties) {
        final Collection<Order> newOrders = new ArrayList<>();
        for (final String property : properties) {
            newOrders.add(new Order(direction, property));
        }
        orders = newOrders.toArray(new Order[0]);
    }
    /**
     * コンストラクタ
     * @param direction ソート方向
     * @param properties ソート属性
     */
    public Sort(final Direction direction, final String... properties) {
        final Collection<Order> newOrders = new ArrayList<>();
        for (final String property : properties) {
            newOrders.add(new Order(direction, property));
        }
        orders = newOrders.toArray(new Order[0]);
    }
    /**
     * コンストラクタ
     * @param properties ソート属性
     */
    public Sort(final String... properties) {
        final Collection<Order> newOrders = new ArrayList<>();
        for (final String property : properties) {
            newOrders.add(new Order(Direction.ASC, property));
        }
        orders = newOrders.toArray(new Order[0]);
    }
    /**
     * ソート条件イテレータの取得
     * @return ソート条件イテレータ
     */
    public Iterator<Order> iterator() {
        return Arrays.asList(orders).iterator();
    }
    /** 個別ソート条件 */
    public static class Order {
        /** ソート方向 */
        private final Direction direction;
        /** ソート属性 */
        private final String property;
        /**
         * コンストラクタ
         * @param direction ソート方向
         * @param property ソート属性
         */
        public Order(final Direction direction, final String property) {
            this.direction = direction;
            this.property = property;
        }
        /**
         * コンストラクタ
         * @param property ソート属性
         */
        public Order(final String property) {
            this(Direction.ASC, property);
        }
        /**
         * {@link #direction} の取得
         * @return {@link #direction}
         */
        public Direction getDirection() {
            return direction;
        }
        /**
         * {@link #property} の取得
         * @return {@link #property}
         */
        public String getProperty() {
            return property;
        }
    }
    /** ソート方向 */
    public static enum Direction {
        /** 昇順 */
        ASC,
        /** 降順 */
        DESC;
    }
}
