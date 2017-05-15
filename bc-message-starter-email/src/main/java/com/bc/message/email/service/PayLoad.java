package com.bc.message.email.service;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.mail.SimpleMailMessage;

import java.util.Date;
import java.util.List;

import static com.sun.xml.internal.ws.util.xml.XMLReaderComposite.State.Payload;

/**
 * Created with IntelliJ IDEA.
 * User: banchun
 * Date:  2017-05-15
 * Time:  上午 11:19.
 * Description:
 * To change this template use File | Settings | File Templates.
 */
public class PayLoad {

    private SimpleMailMessage mailMassage;
    public PayLoad(SimpleMailMessage mailMassage) {
        this.mailMassage = mailMassage;
    }

    public SimpleMailMessage getMailMassage() {
        return mailMassage;
    }

    public void setMailMassage(SimpleMailMessage mailMassage) {
        this.mailMassage = mailMassage;
    }

    public static Builder newBuilder(){
        return new Builder();
    }

    public static class Builder{
        private String from;

        private String replyTo;

        private String[] to;

        private String[] cc;

        private String[] bcc;

        private Date sentDate;

        private String subject;

        private String text;

        public Builder setFrom(String from){
            this.from = from;
            return this;
        }

        public Builder setReplyTo(String replyTo){
            this.replyTo = replyTo;
            return this;
        }


        public Builder setTo(List<String> to){
            if(CollectionUtils.isNotEmpty(to)){
                this.to = to.toArray(new String[to.size()]);
            }
            return this;
        }

        public Builder setTo(String[] to){
            if(to != null){
                this.to = copy(to);
            }
            return this;
        }

        public Builder setCc(List<String> cc){
            if(CollectionUtils.isNotEmpty(cc)){
                this.cc = cc.toArray(new String[cc.size()]);
            }
            return this;
        }

        public Builder setCc(String[] cc){
            if(cc != null){
                this.cc = copy(cc);
            }
            return this;
        }

        public Builder setBcc(List<String> bcc){
            if(CollectionUtils.isNotEmpty(bcc)){
                this.bcc = bcc.toArray(new String[bcc.size()]);
            }
            return this;
        }

        public Builder setBcc(String[] bcc){
            if(bcc != null){
                this.bcc = copy(bcc);
            }
            return this;
        }

        public Builder setSendDate(Date sentDate){
            this.sentDate = sentDate;
            return this;
        }
        public Builder setSubject(String subject){
            this.subject = subject;
            return this;
        }
        public Builder setText(String text){
            this.text = text;
            return this;
        }

        public PayLoad build(){
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(this.from);
            message.setReplyTo(this.replyTo);
            message.setTo(this.to);
            message.setCc(this.cc);
            message.setBcc(this.bcc);
            message.setSentDate(this.sentDate);
            message.setSubject(this.subject);
            message.setText(this.text);
            return new PayLoad(message);
        }


    }

    public static String[] copy(String[] state) {
        String[] copy = new String[state.length];
        System.arraycopy(state, 0, copy, 0, state.length);
        return copy;
    }
}
