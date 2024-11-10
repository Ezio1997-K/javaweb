package com.bookstore.controller;


import com.bookstore.pojo.Cart;
import com.bookstore.pojo.User;
import com.bookstore.service.CartItemService;
import com.bookstore.service.UserService;

import javax.servlet.http.HttpSession;

public class UserController {

    private UserService userService ;
    private CartItemService cartItemService;

    public String login(String uname , String pwd, HttpSession session){

        User user = userService.login(uname, pwd);

        //System.out.println("user = " + user);
        if (user != null) {
            Cart cart = cartItemService.getCart(user);
            user.setCart(cart);
            session.setAttribute("currUser",user);
            return "redirect:book.do";
        }
        return "user/login";
    }
}
