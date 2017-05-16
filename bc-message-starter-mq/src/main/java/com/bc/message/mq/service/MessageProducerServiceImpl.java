package com.bc.message.mq.service;

import com.bc.message.mq.message.BaseMessage;
import com.bc.message.mq.message.MQFactory;
import com.bc.message.mq.message.QueueMessage;

import javax.jms.*;

/**
 * Created with IntelliJ IDEA.
 * User: banchun
 * Date:  2017-05-16
 * Time:  下午 4:47.
 * Description:
 * To change this template use File | Settings | File Templates.
 */
public class MessageProducerServiceImpl implements MessageProducerService {

    MQFactory factory;

    public MessageProducerServiceImpl(MQFactory factory){
        this.factory = factory;
    }

    @Override
    public void sendMessage(String text) {
        Message message = null;
        try {
            message = this.factory.getSession().createTextMessage(text);
        } catch (JMSException e) {
            e.printStackTrace();
        }
        try {
            this.factory.getProducer().send(message);
        } catch (JMSException e) {
            e.printStackTrace();
        }finally {
            try {
                this.factory.getSession().commit();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 发送自定义普通消息
     *
     * @param message
     */
    @Override
    public void sendMessage(BaseMessage message) {
        try {
            ObjectMessage msg = this.factory.getSession().createObjectMessage();
            msg.setObject(message);
            this.factory.getProducer().send(msg);
        } catch (JMSException e) {
            e.printStackTrace();
        }finally {
            try {
                this.factory.getSession().commit();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 发送自定义延时消息
     *
     * @param message
     * @param delay   延时时间，单位秒
     */
    @Override
    public void sendDelayMessage(BaseMessage message, Long delay) {

    }

    /**
     * 发送定时消息
     *
     * @param message
     * @param cron    表达式 比如：0 * * * *
     */
    @Override
    public void sendScheduleMessage(BaseMessage message, String cron) {

    }
}
