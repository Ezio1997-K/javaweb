package com.bookstore.dao.impl;


import com.atguigu.myssm.basedao.BaseDAO;
import com.bookstore.dao.UserDAO;
import com.bookstore.pojo.User;

public class UserDAOImpl extends BaseDAO<User> implements UserDAO {
    @Override
    public User getUser(String uname, String pwd) {
        return load("select * from t_user where uname like ? and pwd like ? " , uname , pwd );
    }
}
