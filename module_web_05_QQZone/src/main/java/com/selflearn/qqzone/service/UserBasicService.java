package com.selflearn.qqzone.service;

import com.selflearn.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * ClassName:UserService
 * Package:com.selflearn.qqzone.service
 * Description:
 */
public interface UserBasicService {
    UserBasic login(String loginId, String pwd);

    List<UserBasic> getFriendList(UserBasic userBasic);
    UserBasic getUserBasicById(Integer id);
}
