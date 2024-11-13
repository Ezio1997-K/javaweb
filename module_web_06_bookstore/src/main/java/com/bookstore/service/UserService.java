package com.bookstore.service;


import com.bookstore.pojo.User;

public interface UserService {
    User login(String uname , String pwd );
    void regist(User user);

    User getUser(String uname);
}
