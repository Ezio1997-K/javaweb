package com.bookstore.service;

import com.bookstore.pojo.OrderBean;
import com.bookstore.pojo.User;

import java.sql.SQLException;
import java.util.List;

/**
 * ClassName:OrderService
 * Package:com.bookstore.service
 * Description:
 *
 */
public interface OrderService {
    void addOrderBean(OrderBean orderBean);

    List<OrderBean> getOrderList(User user) throws Exception;
}
