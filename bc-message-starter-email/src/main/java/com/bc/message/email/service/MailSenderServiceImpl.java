package com.bc.message.email.service;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: banchun
 * Date:  2017-05-15
 * Time:  上午 11:22.
 * Description:
 * To change this template use File | Settings | File Templates.
 */
public class MailSenderServiceImpl implements MailSenderService{
    JavaMailSender mailSender;

    public MailSenderServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void send(String from, String to, String cc, String subject, String content) {
        String[] tos = null;
        String[] ccs = null;
        if(StringUtils.isNotBlank(to)){
            tos = new String[]{to};
        }
        if(StringUtils.isNotBlank(cc)){
            ccs = new String[]{cc};
        }
        send(from,tos,ccs,subject,content);
    }

    @Override
    public void send(String from, String to, List<String> ccs, String subject, String content) {
        String[] tos = null;
        String[] cc = null;
        if(StringUtils.isNotBlank(to)){
            tos = new String[]{to};
        }
        if(CollectionUtils.isNotEmpty(ccs)){
            cc = ccs.toArray(new String[ccs.size()]);
        }
        send(from,tos,cc,subject,content);
    }

    @Override
    public void send(String from, String to, String[] ccs, String subject, String content) {
        String[] tos = null;
        if(StringUtils.isNotBlank(to)){
            tos = new String[]{to};
        }
        send(from,tos,ccs,subject,content);
    }

    @Override
    public void send(String from, String[] tos, String cc, String subject, String content) {
        String[] ccs = null;
        if(StringUtils.isNotBlank(cc)){
            ccs = new String[]{cc};
        }
        send(from,tos,ccs,subject,content);
    }

    @Override
    public void send(String from, List<String> tos, String cc, String subject, String content) {
        String[] to = null;
        if(CollectionUtils.isNotEmpty(tos)){
            to = tos.toArray(new String[tos.size()]);
        }
        String[] ccs = null;
        if(StringUtils.isNotBlank(cc)){
            ccs = new String[]{cc};
        }
        send(from,to,ccs,subject,content);
    }

    @Override
    public void send(String from, List<String> tos, List<String> ccs, String subject, String content) {
        String[] to = null;
        String[] cc = null;
        if(CollectionUtils.isNotEmpty(tos)){
            to = tos.toArray(new String[tos.size()]);
        }
        if(CollectionUtils.isNotEmpty(ccs)){
            cc = ccs.toArray(new String[ccs.size()]);
        }
        send(from,to,cc,subject,content);
    }

    @Override
    public void send(String from, String[] tos, String[] ccs, String subject, String content) {
        PayLoad payload = PayLoad.newBuilder()
                .setFrom(from)
                .setTo(PayLoad.copy(tos))
                .setCc(PayLoad.copy(ccs))
                .setSubject(subject)
                .setText(content)
                .build();
        send(payload);
    }

    @Override
    public void send(PayLoad payload) {
        SimpleMailMessage message = payload.getMailMassage();
        mailSender.send(message);
    }

    @Override
    public JavaMailSender getSender() {
        return mailSender;
    }
}
