package com.learnmba.mapper;

import com.learnmba.pojo.User;

import java.util.List;

/**
 * ClassName:UserMapper
 * Package:com.learnmba.mapper
 * Description:
 *
 */
public interface UserMapper {
    List<User> selectUser();
}
