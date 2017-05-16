package com.bc.message.mq.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: banchun
 * Date:  2017-05-15
 * Time:  下午 3:55.
 * Description:
 * To change this template use File | Settings | File Templates.
 */
public class MessageProducer implements Runnable {

    private String url;
    private String user;
    private String password;
    private final String QUEUE;

    public MessageProducer(String queue, String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.QUEUE = queue;
    }

    @Override
    public void run() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                user, password, url);
        Session session = null;
        Destination sendQueue;
        Connection connection = null;

        int messageCount = 0;
        try {
            connection = connectionFactory.createConnection();

            connection.start();
            System.out.println(Thread.currentThread().getName() + " start");

            while (true) {
                session = connection.createSession(true,
                        Session.SESSION_TRANSACTED);

                sendQueue = session.createQueue(QUEUE);
                javax.jms.MessageProducer sender = session.createProducer(sendQueue);
                TextMessage outMessage = session.createTextMessage();


                outMessage.setText(new Date() + "现在发送是第" + messageCount + "条消息");

                sender.send(outMessage);

                session.commit();

                sender.close();

                if ((++messageCount) == 10) {
                    // 发够十条消息退出
                    break;
                }
                Thread.sleep(1000);
            }

            connection.close();
            System.out.println(Thread.currentThread().getName() + " close");
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getQUEUE() {
        return QUEUE;
    }
}
