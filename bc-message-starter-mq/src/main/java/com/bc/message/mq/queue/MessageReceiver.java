package com.bc.message.mq.queue;

import com.bc.message.mq.message.QueueMessage;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;


/**
 * Created with IntelliJ IDEA.
 * User: banchun
 * Date:  2017-05-15
 * Time:  下午 3:29.
 * Description:
 * To change this template use File | Settings | File Templates.
 */
public class MessageReceiver implements Runnable{

    private String url;
    private String user;
    private String password;
    private final String QUEUE;


    public MessageReceiver(String queue, String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.QUEUE = queue;
    }
    @Override
    public void run() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(user, password, url);
        Session session = null;
        Destination destination = null;
        try {
            Connection connection = connectionFactory.createConnection();
            session = connection
                    .createSession(true, Session.SESSION_TRANSACTED);
            destination = session.createQueue(QUEUE);
            MessageConsumer consumer = session.createConsumer(destination);
            connection.start();

            System.out.println(Thread.currentThread().getName()+" start");
            while (true) {
                Message message = consumer.receive();

                if (message instanceof ObjectMessage) {
                    ObjectMessage receiveMessage = (ObjectMessage) message;
                    if (receiveMessage.getObject() instanceof QueueMessage){
                        System.out.println(((QueueMessage) receiveMessage.getObject()).getKey());
                    }
                    System.out.println("我是Receiver,收到消息如下: \r\n"
                            + receiveMessage);
                }else if(message instanceof TextMessage){
                    TextMessage textMessage =(TextMessage) message;
                    System.out.println("我是Receiver,收到消息如下: \r\n"
                            + textMessage.getText());
                }else {
                    session.commit();
                    break;
                }

            }
            connection.close();
            System.out.println(Thread.currentThread().getName()+" close");
        } catch (JMSException e) {
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
