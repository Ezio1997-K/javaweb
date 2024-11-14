package com.bookstore.service.impl;

import com.bookstore.dao.CartItemDAO;
import com.bookstore.pojo.Book;
import com.bookstore.pojo.Cart;
import com.bookstore.pojo.CartItem;
import com.bookstore.pojo.User;
import com.bookstore.service.BookService;
import com.bookstore.service.CartItemService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName:CartItemServiceImpl
 * Package:com.bookstore.service.impl
 * Description:
 *
 */
public class CartItemServiceImpl implements CartItemService {

    private CartItemDAO cartItemDAO ;
    private BookService bookService ;

    @Override
    public void addCartItem(CartItem cartItem) {
        cartItemDAO.addCartItem(cartItem);
    }

    @Override
    public void updateCartItem(CartItem cartItem) {
        cartItemDAO.updateCartItem(cartItem);
    }

    @Override
    public void addOrUpdateCartItem(CartItem cartItem , Cart cart) {
        //1.如果当前用户的购物车中已经存在这个图书了，那么将购物车中这本图书的数量+1
        //2.否则，在我的购物车中新增一个这本图书的CartItem，数量是1
        //判断当前用户的购物车中是否有这本书的CartItem，有->update , 无->add
        if(cart!=null){
            Map<Integer, CartItem> cartItemMap = cart.getCartItemMap();
            if(cartItemMap==null){
                cartItemMap = new HashMap<>();
            }

            if(cartItemMap.containsKey(cartItem.getBook().getId())){
                CartItem cartItemTemp = cartItemMap.get(cartItem.getBook().getId());
                cartItemTemp.setBuyCount(cartItemTemp.getBuyCount()+1);
                updateCartItem(cartItemTemp);
            }else{
                addCartItem(cartItem);
            }
        }else{  //连购物车都没有的情况
            addCartItem(cartItem);
        }
    }

    @Override
    public List<CartItem> getCartItemList(User user) {
        List<CartItem> cartItemList = cartItemDAO.getCartItemList(user);
        for(CartItem cartItem : cartItemList){
            Book book = bookService.getBook(cartItem.getBook().getId());
            cartItem.setBook(book);
            cartItem.getXj();
        }

        return cartItemList;
    }

    @Override
    public Cart getCart(User user) {
        /*List<CartItem> cartItemList = cartItemDAO.getCartItemList(user);
        Cart cart = new Cart();
        Map<Integer, CartItem> map = new HashMap<>();
        for (CartItem cartItem : cartItemList) {
            map.put(user.getId(),cartItem);
        }
        cart.setCartItemMap(map);
        return cart;*/
        //查询当前用户的所有购物项
        List<CartItem> cartItemList = getCartItemList(user);
        //创建一个集合用来存储购物车中购物项的集合
        Map<Integer,CartItem> cartItemMap = new HashMap<>();
        for (CartItem cartItem : cartItemList){
            //将用户的所有的购物项封装到集合中
            cartItemMap.put(cartItem.getBook().getId(),cartItem);
        }
        Cart cart = new Cart();
        //补全购物车中购物项的内容
        cart.setCartItemMap(cartItemMap);

        return cart;
    }
}
