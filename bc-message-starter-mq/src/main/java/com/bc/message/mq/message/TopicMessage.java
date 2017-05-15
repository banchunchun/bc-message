package com.bc.message.mq.message;

import java.io.Serializable;

/**
 * mq 消息抽象类
 * Created with IntelliJ IDEA.
 * User: banchun
 * Date:  2017-05-15
 * Time:  下午 4:35.
 * Description:
 * To change this template use File | Settings | File Templates.
 */
public  class TopicMessage extends BaseMessage implements Serializable{

    private String topic;


    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
