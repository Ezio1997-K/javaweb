package com.bookstore.dao.impl;

import com.bookstore.dao.CartItemDAO;
import com.bookstore.pojo.CartItem;
import com.bookstore.pojo.User;
import com.myssm.basedao.BaseDAO;

import java.util.List;

/**
 * ClassName:CartItemDAOImpl
 * Package:com.bookstore.dao.impl
 * Description:
 *
 */
public class CartItemDAOImpl extends BaseDAO<CartItem> implements CartItemDAO {
    @Override
    public void addCartItem(CartItem cartItem) {
        executeUpdate("insert into t_cart_item values(0,?,?,?)",cartItem.getBook().getId(),cartItem.getBuyCount(),cartItem.getUserBean().getId());
    }

    @Override
    public void updateCartItem(CartItem cartItem) {
        executeUpdate("update t_cart_item set buyCount = ? where id = ? " , cartItem.getBuyCount(),cartItem.getId()) ;
    }

    @Override
    public List<CartItem> getCartItemList(User user) {
        return executeQuery("select * from t_cart_item where userBean = ? " , user.getId());
    }

    @Override
    public void delCartItem(CartItem cartItem) {
        super.executeUpdate("delete from t_cart_item where id = ?" , cartItem.getId());
    }
}

