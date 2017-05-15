package com.bc.message.email.service;

import org.springframework.mail.javamail.JavaMailSender;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: banchun
 * Date:  2017-05-15
 * Time:  上午 11:19.
 * Description:
 * To change this template use File | Settings | File Templates.
 */
public interface MailSenderService {

    void send(String from, String to,String cc,String subject,String content);

    void send(String from, String to, List<String> ccs, String subject, String content);

    void send(String from, String to,String[] ccs,String subject,String content);

    void send(String from, String[] tos,String cc,String subject,String content);

    void send(String from, List<String> tos,String cc,String subject,String content);

    void send(String from, List<String> tos,List<String> ccs,String subject,String content);

    void send(String from, String[] tos,String[] ccs,String subject,String content);

    void send(PayLoad payload);

    JavaMailSender getSender();
}
