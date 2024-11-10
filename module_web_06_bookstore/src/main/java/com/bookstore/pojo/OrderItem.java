package com.bookstore.pojo;

public class OrderItem {
    //订单项id，自增
    private Integer id ;
    // 订单项图书
    private Book book ;                 //M:1
    // 订单项购买数量
    private Integer buyCount ;
    // 订单项所属订单
    private OrderBean orderBean ;       //M:1

    public OrderItem(){}

    public OrderItem(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public OrderBean getOrderBean() {
        return orderBean;
    }

    public void setOrderBean(OrderBean orderBean) {
        this.orderBean = orderBean;
    }
}
