package com.bc.message.mq.service;

import com.bc.message.mq.message.BaseMessage;

/**
 * Created with IntelliJ IDEA.
 * User: banchun
 * Date:  2017-05-15
 * Time:  下午 4:25.
 * Description:
 * To change this template use File | Settings | File Templates.
 */
public interface MessageProducerService {

    void sendMessage(String text);

    /**
     * 发送自定义普通消息
     * @param message
     */
    void sendMessage(BaseMessage message);

    /**
     * 发送自定义延时消息
     * @param message
     * @param delay 延时时间，单位秒
     */
    void sendDelayMessage(BaseMessage message,Long delay);

    /**
     * 发送定时消息
     * @param message
     * @param cron 表达式 比如：0 * * * *
     */
    void sendScheduleMessage(BaseMessage message,String cron);
}
