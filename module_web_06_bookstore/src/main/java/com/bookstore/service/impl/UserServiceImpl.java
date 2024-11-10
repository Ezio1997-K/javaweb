package com.bookstore.service.impl;


import com.bookstore.dao.UserDAO;
import com.bookstore.pojo.User;
import com.bookstore.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO ;

    @Override
    public User login(String uname, String pwd) {
        return userDAO.getUser(uname,pwd);
    }
}
