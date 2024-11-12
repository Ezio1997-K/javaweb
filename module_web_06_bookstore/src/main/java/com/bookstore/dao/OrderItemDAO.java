package com.bookstore.dao;

import com.bookstore.pojo.OrderItem;

/**
 * ClassName:OrderItemDAO
 * Package:com.bookstore.dao
 * Description:
 *
 */
public interface OrderItemDAO {
    //添加订单项
    void addOrderItem(OrderItem orderItem);
}
