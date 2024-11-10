package com.bookstore.controller;

import com.bookstore.pojo.Cart;
import com.bookstore.pojo.CartItem;
import com.bookstore.pojo.User;
import com.bookstore.service.CartItemService;
import com.bookstore.pojo.Book;

import javax.servlet.http.HttpSession;

/**
 * ClassName:CartController
 * Package:com.bookstore.controller
 * Description:
 *
 */
public class CartController {

    private CartItemService cartItemService ;

    //加载当前用户的购物车信息
    public String index(HttpSession session){
        User user =(User)session.getAttribute("currUser");
        Cart cart = cartItemService.getCart(user);
        user.setCart(cart);
        session.setAttribute("currUser",user);
        return "cart/cart";
    }

    public String addCart(Integer bookId , HttpSession session){
        User user = (User)session.getAttribute("currUser");
        CartItem cartItem = new CartItem(new Book(bookId),1,user);
        //将指定的图书添加到当前用户的购物车中
        cartItemService.addOrUpdateCartItem(cartItem,user.getCart());

        return "redirect:cart.do";
    }

    public String editCart(Integer cartItemId , Integer buyCount){
        cartItemService.updateCartItem(new CartItem(cartItemId , buyCount));
        return "redirect:cart.do";
    }
}

