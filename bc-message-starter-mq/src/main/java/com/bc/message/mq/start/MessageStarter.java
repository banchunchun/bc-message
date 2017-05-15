package com.bc.message.mq.start;

import com.bc.message.mq.queue.MessageProducer;
import com.bc.message.mq.queue.MessageReceiver;

/**
 * Created with IntelliJ IDEA.
 * User: banchun
 * Date:  2017-05-15
 * Time:  下午 3:58.
 * Description:
 * To change this template use File | Settings | File Templates.
 */
public class MessageStarter {

    public static void main(String[] args) {
        final String QUEUE = "my-first-queue";


        String url = "tcp://localhost:61616";
        String user = "admin";
        String password = "admin";
        new Thread(new MessageReceiver(QUEUE,url,user,password), "Name-Receiver").start();
        new Thread(new MessageProducer(QUEUE,url,user,password), "Name-Sender").start();
    }
}
