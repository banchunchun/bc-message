package com.bc.message.mq.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created with IntelliJ IDEA.
 * User: banchun
 * Date:  2017-05-16
 * Time:  上午 11:10.
 * Description:
 * To change this template use File | Settings | File Templates.
 */
@ConfigurationProperties(prefix = "message.mq")
public class DefaultMqProducerProperties implements MqProducerProperties{

    private String topic;

    private String queue;

    private String username;

    private String password;

    private String url;

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String getTopic() {
        return topic;
    }

    @Override
    public String getQueue() {
        return queue;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassWord() {
        return password;
    }

    @Override
    public String getUrl() {
        return url;
    }
}
