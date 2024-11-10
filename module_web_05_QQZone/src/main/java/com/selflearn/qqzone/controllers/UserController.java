package com.selflearn.qqzone.controllers;

import com.selflearn.qqzone.pojo.Topic;
import com.selflearn.qqzone.pojo.UserBasic;
import com.selflearn.qqzone.service.TopicService;
import com.selflearn.qqzone.service.UserBasicService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * ClassName:UserController
 * Package:com.selflearn.qqzone.controllers
 * Description:
 *
 */
public class UserController {

    private UserBasicService userBasicService ;
    private TopicService topicService ;

    public String login(String loginId , String pwd , HttpSession session){
        //1.登录验证
        UserBasic userBasic = userBasicService.login(loginId, pwd);
        if(userBasic!=null){
            //1-1 获取相关的好友信息
            List<UserBasic> friendList = userBasicService.getFriendList(userBasic);
            //1-2 获取相关的日志列表信息(但是，日志只有id，没有其他信息）
            List<Topic> topicList = topicService.getTopicList(userBasic);

            //1-3 为userBasic对象设置相关的属性
            userBasic.setFriendList(friendList);
            userBasic.setTopicList(topicList);

            //保存登录者的信息到session中
            session.setAttribute("userBasic",userBasic);
            //判断当前进入的是谁的空间
            session.setAttribute("friend",userBasic);
            return "index";
        }else{
            return "login";
        }
    }
    public String friend(Integer id, HttpSession session){
        //1.根据id获取指定的用户信息
        UserBasic currFriend = userBasicService.getUserBasicById(id);

        List<Topic> topicList = topicService.getTopicList(currFriend);

        currFriend.setTopicList(topicList);

        session.setAttribute("friend",currFriend);

        return "index";
    }
}