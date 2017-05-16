package com.bc.message.mq.configuration;

/**
 * Created with IntelliJ IDEA.
 * User: banchun
 * Date:  2017-05-16
 * Time:  上午 11:08.
 * Description:
 * To change this template use File | Settings | File Templates.
 */
public interface MqProducerProperties {

     String getTopic();

     String getQueue();

     String getUsername();

     String getPassWord();

     String getUrl();
}
