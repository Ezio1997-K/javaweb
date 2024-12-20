package com.bookstore.pojo;

import java.math.BigDecimal;

//我们应该还需要设计一个Cart类，代表购物车这个实体
public class CartItem {
    // 购物项id，自增
    private Integer id ;
    // 购物项图书
    private Book book ;
    // 购物项购买数量
    private Integer buyCount ;
    // 购物项所属用户
    private User userBean;

    private Double xj;//小计

    public CartItem(){}

    public CartItem(Integer id) {
        this.id = id;
    }

    public CartItem(Integer id, Integer buyCount) {
        this.id = id;
        this.buyCount = buyCount;
    }

    public CartItem(Book book, Integer buyCount, User userBean) {
        this.book = book;
        this.buyCount = buyCount;
        this.userBean = userBean;
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

    public User getUserBean() {
        return userBean;
    }

    public void setUserBean(User userBean) {
        this.userBean = userBean;
    }

    public Double getXj() {
        BigDecimal bigDecimalPrice = new BigDecimal(""+getBook().getPrice());
        BigDecimal bigDecimalBuyCount = new BigDecimal(""+buyCount);
        BigDecimal bigDecimalXJ = bigDecimalPrice.multiply(bigDecimalBuyCount);
        xj = bigDecimalXJ.doubleValue() ;
        return xj;
    }
}
