package com.bookstore.pojo;

import java.util.Date;
import java.util.List;

public class OrderBean {
    // 订单id，自增
    private Integer id ;
    // 订单号
    private String orderNo ;
    // 订单日期
    private Date orderDate;
    // 订单用户
    private User orderUser ;
    // 订单金额
    private Double orderMoney ;
    // 订单状态 0：待付款 1：待发货 2：待收货 3：待评价 4：已完成 5：已取消
    private Integer orderStatus;
    // 订单明细列表

    private List<OrderItem> orderItemList ;     //1:N

    public OrderBean(){}
    public OrderBean(Integer id){
        this.id= id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public User getOrderUser() {
        return orderUser;
    }

    public void setOrderUser(User orderUser) {
        this.orderUser = orderUser;
    }

    public Double getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Double orderMoney) {
        this.orderMoney = orderMoney;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
