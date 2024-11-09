package com.selflearn.qqzone.service.impl;

import com.selflearn.qqzone.DAO.UserBasicDAO;
import com.selflearn.qqzone.pojo.UserBasic;
import com.selflearn.qqzone.service.UserBasicService;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:UserServiceImpl
 * Package:com.selflearn.qqzone.service.impl
 * Description:
 *
 */
public class UserServiceImpl implements UserBasicService {
    private UserBasicDAO userBasicDAO;

    @Override
    public UserBasic login(String loginId, String pwd) {
        UserBasic userBasic = userBasicDAO.getUserBasic(loginId,pwd);
        return userBasic;
    }

    @Override
    public List<UserBasic> getFriendList(UserBasic userBasic) {
        List<UserBasic> userBasicList = userBasicDAO.getUserBasicList(userBasic);
        List<UserBasic> friendList = new ArrayList<>(userBasicList.size());
        for (int i = 0; i < userBasicList.size(); i++) {
            UserBasic friend = userBasicList.get(i);
            friend = userBasicDAO.getUserBasicById(friend.getId());
            friendList.add(friend);
        }
        return friendList;
    }
}
