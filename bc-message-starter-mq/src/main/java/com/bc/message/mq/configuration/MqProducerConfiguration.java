package com.bc.message.mq.configuration;

import com.bc.message.mq.message.MQFactory;
import com.bc.message.mq.service.MessageProducerService;
import com.bc.message.mq.service.MessageProducerServiceImpl;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.*;

/**
 * Created with IntelliJ IDEA.
 * User: banchun
 * Date:  2017-05-16
 * Time:  上午 11:04.
 * Description:
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class MqProducerConfiguration {

    private Session session;

    MessageProducer producer;

    @Bean
    @ConditionalOnMissingBean
    public MqProducerProperties onsProducerProperties(){
        return new DefaultMqProducerProperties();
    }
    @Bean
    @ConditionalOnMissingBean
    public MessageProducerService messageProducerService(MqProducerProperties properties){
        return new MessageProducerServiceImpl(factory(properties));
    }

    @Bean
    @ConditionalOnMissingBean
    public MQFactory factory(MqProducerProperties properties){
        MQFactory factory = new MQFactory();
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                properties.getUsername(), properties.getPassWord(), properties.getUrl());
        try {
            Connection connection = connectionFactory.createConnection();

            connection.start();
            System.out.println(Thread.currentThread().getName() + " start");
            session = connection.createSession(true,Session.SESSION_TRANSACTED);
            Destination destination = session.createQueue(properties.getQueue());

            MessageProducer producer = session.createProducer(destination);


            factory.setProducer(producer);
            factory.setSession(session);

        } catch (JMSException e) {
            e.printStackTrace();
        }
        return factory;
    }
}
