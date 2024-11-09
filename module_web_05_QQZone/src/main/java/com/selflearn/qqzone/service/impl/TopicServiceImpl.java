package com.selflearn.qqzone.service.impl;

import com.selflearn.qqzone.DAO.TopicDAO;
import com.selflearn.qqzone.pojo.Topic;
import com.selflearn.qqzone.pojo.UserBasic;
import com.selflearn.qqzone.service.TopicService;

import java.util.List;

/**
 * ClassName:TopicServiceImpl
 * Package:com.selflearn.qqzone.service.impl
 * Description:
 *
 */
public class TopicServiceImpl implements TopicService {
    private TopicDAO topicDAO;
    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {
        return topicDAO.getTopicList(userBasic);
    }
}
