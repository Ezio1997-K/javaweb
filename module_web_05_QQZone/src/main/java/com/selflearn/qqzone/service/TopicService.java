package com.selflearn.qqzone.service;

import com.selflearn.qqzone.pojo.Topic;
import com.selflearn.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * ClassName:TopicService
 * Package:com.selflearn.qqzone.service
 * Description:
 *
 */
public interface TopicService {
    //查询特定用户的日志列表
    List<Topic> getTopicList(UserBasic userBasic) ;
}

