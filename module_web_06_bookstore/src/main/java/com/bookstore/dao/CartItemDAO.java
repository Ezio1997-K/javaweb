package com.bookstore.dao;

import com.bookstore.pojo.CartItem;
import com.bookstore.pojo.User;

import java.util.List;

/**
 * ClassName:CartItemDAO
 * Package:com.bookstore.dao
 * Description:
 *
 */
public interface CartItemDAO {
    //新增购物车项
    void addCartItem(CartItem cartItem);
    //修改特定的购物车项
    void updateCartItem(CartItem cartItem);
    //获取特定用户的所有购物车项
    List<CartItem> getCartItemList(User user);
    //删除特定的购物车项
    void delCartItem(CartItem cartItem);
}
