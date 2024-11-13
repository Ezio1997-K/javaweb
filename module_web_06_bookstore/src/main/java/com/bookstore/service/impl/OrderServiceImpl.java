package com.bookstore.service.impl;

import com.bookstore.dao.CartItemDAO;
import com.bookstore.dao.OrderDAO;
import com.bookstore.dao.OrderItemDAO;
import com.bookstore.pojo.CartItem;
import com.bookstore.pojo.OrderBean;
import com.bookstore.pojo.OrderItem;
import com.bookstore.pojo.User;
import com.bookstore.service.OrderService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * ClassName:OrderServiceImpl
 * Package:com.bookstore.service.impl
 * Description:
 *
 */
public class OrderServiceImpl implements OrderService {
    private OrderDAO orderDAO;
    private OrderItemDAO orderItemDAO;
    private CartItemDAO cartItemDAO;
    @Override
    public void addOrderBean(OrderBean orderBean) {
        //1) 订单表添加一条记录
        //2) 订单详情表添加7条记录
        //3) 购物车项表中需要删除对应的7条记录
        orderDAO.addOrderBean(orderBean);//执行完这一步，orderBean中的id是有值的
        //第2步：
        //orderBean中的orderItemList是空的，此处我们应该根据用户的购物车中的购物车项去转换成一个一个的订单项
        User currUser = orderBean.getOrderUser();
        Map<Integer, CartItem> cartItemMap = currUser.getCart().getCartItemMap();
        for(CartItem cartItem : cartItemMap.values()){
            OrderItem orderItem = new OrderItem();
            orderItem.setBook(cartItem.getBook());
            orderItem.setBuyCount(cartItem.getBuyCount());
            orderItem.setOrderBean(orderBean);
            orderItemDAO.addOrderItem(orderItem);
        }

        //第3步：

        for(CartItem cartItem : cartItemMap.values()){
            cartItemDAO.delCartItem(cartItem);
        }

    }

    @Override
    public List<OrderBean> getOrderList(User user) throws Exception {
        List<OrderBean> orderBeanList = orderDAO.getOrderList(user);

        for (OrderBean orderBean: orderBeanList) {
            Integer totalBookCount = orderDAO.getOrderTotalBookCount(orderBean);
            orderBean.setTotalBookCount(totalBookCount);
        }

        return orderBeanList ;
    }
}
