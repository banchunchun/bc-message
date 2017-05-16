package com.bc.message.mq.message;

import javax.jms.MessageProducer;
import javax.jms.Session;

/**
 * Created with IntelliJ IDEA.
 * User: banchun
 * Date:  2017-05-16
 * Time:  下午 6:02.
 * Description:
 * To change this template use File | Settings | File Templates.
 */
public class MQFactory {

     MessageProducer producer;

     Session session;


    public  MessageProducer getProducer() {
        return producer;
    }

    public  void setProducer(MessageProducer producer) {
        this.producer = producer;
    }

    public  Session getSession() {
        return session;
    }

    public  void setSession(Session session) {
        this.session = session;
    }
}
