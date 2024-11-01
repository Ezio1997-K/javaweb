package com.learnmba.mapper;

import com.learnmba.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * ClassName:UserMapper
 * Package:com.learnmba.mapper
 * Description:
 *
 */
public interface UserMapper {
    List<User> selectUser();
    @Select("select * from tb_user where id = #{id}")
    User selectUserById(int id);
}
