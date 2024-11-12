package com.bookstore.dao.impl;

import com.atguigu.myssm.basedao.BaseDAO;
import com.bookstore.dao.OrderItemDAO;
import com.bookstore.pojo.OrderItem;

/**
 * ClassName:OrderItemDAOImpl
 * Package:com.bookstore.dao.impl
 * Description:
 *
 */
public class OrderItemDAOImpl extends BaseDAO<OrderItem> implements OrderItemDAO {
    @Override
    public void addOrderItem(OrderItem orderItem) {
        super.executeUpdate("insert into t_order_item values(0,?,?,?)",orderItem.getBook().getId(),
                orderItem.getBuyCount(),orderItem.getOrderBean().getId()) ;
    }
}
