package com.bookstore.dao;

import com.bookstore.pojo.OrderBean;

/**
 * ClassName:OrderDAO
 * Package:com.bookstore.dao
 * Description:
 *
 */
public interface OrderDAO {
    //添加订单
    void addOrderBean(OrderBean orderBean);
}
