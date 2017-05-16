package com.bc.message.mq.message;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: banchun
 * Date:  2017-05-15
 * Time:  下午 5:55.
 * Description:
 * To change this template use File | Settings | File Templates.
 */
public class QueueMessage extends BaseMessage implements Serializable {
    private String queue; //队列名称


    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }
}
