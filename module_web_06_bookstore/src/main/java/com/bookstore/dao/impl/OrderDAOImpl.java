package com.bookstore.dao.impl;

import com.bookstore.dao.OrderDAO;
import com.bookstore.pojo.OrderBean;
import com.bookstore.pojo.User;
import com.myssm.basedao.BaseDAO;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ClassName:OrderDAOImpl
 * Package:com.bookstore.dao.impl
 * Description:
 */
public class OrderDAOImpl extends BaseDAO<OrderBean> implements OrderDAO {
    @Override
    public void addOrderBean(OrderBean orderBean) {
        int orderBeanId = super.executeUpdate("insert into t_order values(0,?,?,?,?,?)", orderBean.getOrderNo(),
                orderBean.getOrderDate(), orderBean.getOrderUser().getId(), orderBean.getOrderMoney(), orderBean.getOrderStatus());
        orderBean.setId(orderBeanId);
    }

    @Override
    public Integer getOrderTotalBookCount(OrderBean orderBean) {
        String sql = "SELECT SUM(t3.buyCount) AS totalBookCount , t3.orderBean FROM " +
                "(" +
                "SELECT t1.id , t2.buyCount , t2.orderBean FROM t_order t1 INNER JOIN t_order_item t2 " +
                "ON t1.id = t2.orderBean WHERE t1.orderUser = ? " +
                ") t3 WHERE t3.orderBean = ? GROUP BY t3.orderBean";
        return ((BigDecimal)(executeComplexQuery(sql, orderBean.getOrderUser().getId(), orderBean.getId())[0])).intValue();
    }

    @Override
    public List<OrderBean> getOrderList(User user) throws Exception {
        //return executeQuery("select * from t_order where orderUser =?", user.getId());
        Connection conn = this.getConn();
        String sql = "select * from t_order where orderUser =?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, user.getId());
        ResultSet rs = preparedStatement.executeQuery();
        ResultSetMetaData metaData = rs.getMetaData();
        List<OrderBean> orderBeanList = new ArrayList<>();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        int columnCount = metaData.getColumnCount();
        while (rs.next()) {
            OrderBean orderBean = new OrderBean();
            for (int i = 1; i < columnCount; i++) {
                String columnName = metaData.getColumnLabel(i);
                Object columnValue = rs.getObject(i);
                if (i == 3) {
                    columnValue = Date.from(LocalDateTime.parse(columnValue.toString()).atZone(ZoneId.systemDefault()).toInstant());
                }
                Class clazz = orderBean.getClass();
                Field declaredField = clazz.getDeclaredField(columnName);
                declaredField.setAccessible(true);
                if (i == 4) {
                    declaredField.set(orderBean, new User((Integer) columnValue));
                }else {
                    declaredField.set(orderBean, columnValue);
                }

            }
            orderBeanList.add(orderBean);
        }
        return orderBeanList;
    }
}
