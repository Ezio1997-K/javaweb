package com.bookstore.dao;


import com.bookstore.pojo.User;

public interface UserDAO {
    User getUser(String uname , String pwd );
}
 