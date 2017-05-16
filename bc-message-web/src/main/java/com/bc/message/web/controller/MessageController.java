package com.bc.message.web.controller;

import com.bc.message.mq.message.QueueMessage;
import com.bc.message.mq.message.User;
import com.bc.message.mq.service.MessageProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: banchun
 * Date:  2017-05-16
 * Time:  下午 7:21.
 * Description:
 * To change this template use File | Settings | File Templates.
 */
@RestController
public class MessageController {


    @Autowired
    private MessageProducerService messageProducerService;

    @RequestMapping(value = "/index.htm")
    public void index(HttpServletRequest request, HttpServletResponse response){
        QueueMessage queueMessage = new QueueMessage();
        queueMessage.setQueue("1");
        queueMessage.setKey("banchun");
        queueMessage.setTag("banchun123");

        User user = new User();
        user.setName("hello");
        queueMessage.setClazz(user);

        messageProducerService.sendMessage(queueMessage);

       for (int i = 1;i < 100 ;i ++){
           messageProducerService.sendMessage("i" + i);
       }
    }
}
