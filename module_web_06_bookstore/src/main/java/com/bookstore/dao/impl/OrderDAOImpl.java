package com.bookstore.dao.impl;

import com.atguigu.myssm.basedao.BaseDAO;
import com.bookstore.dao.OrderDAO;
import com.bookstore.pojo.OrderBean;

/**
 * ClassName:OrderDAOImpl
 * Package:com.bookstore.dao.impl
 * Description:
 *
 */
public class OrderDAOImpl extends BaseDAO<OrderBean> implements OrderDAO {
    @Override
    public void addOrderBean(OrderBean orderBean) {
        int orderBeanId = super.executeUpdate("insert into t_order values(0,?,?,?,?,?)",orderBean.getOrderNo(),
                orderBean.getOrderDate(),orderBean.getOrderUser().getId(),orderBean.getOrderMoney(),orderBean.getOrderStatus());
        orderBean.setId(orderBeanId);
    }
}
