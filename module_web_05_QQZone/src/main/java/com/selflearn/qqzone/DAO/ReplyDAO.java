package com.selflearn.qqzone.DAO;

import com.selflearn.qqzone.pojo.Reply;
import com.selflearn.qqzone.pojo.Topic;

import java.util.List;

public interface ReplyDAO {
    //获取指定日志的回复列表
    List<Reply> getReplyList(Topic topic);
    //添加回复
    void addReply(Reply reply);
    //删除回复
    void delReply(Integer id);

}
