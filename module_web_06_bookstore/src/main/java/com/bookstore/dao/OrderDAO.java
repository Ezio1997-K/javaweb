package com.bookstore.dao;

import com.bookstore.pojo.OrderBean;
import com.bookstore.pojo.User;

import java.sql.SQLException;
import java.util.List;

/**
 * ClassName:OrderDAO
 * Package:com.bookstore.dao
 * Description:
 *
 */
public interface OrderDAO {
    //添加订单
    void addOrderBean(OrderBean orderBean);

    Integer getOrderTotalBookCount(OrderBean orderBean);

    List<OrderBean> getOrderList(User user) throws SQLException, Exception;
}
