package com.bc.message.email.configuration;

import com.bc.message.email.service.MailSenderService;
import com.bc.message.email.service.MailSenderServiceImpl;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.activation.MimeType;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: banchun
 * Date:  2017-05-15
 * Time:  上午 11:33.
 * Description:
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@ConditionalOnClass({ MimeMessage.class, MimeType.class })
@ConditionalOnMissingBean(MailSender.class)
public class MailConfiguration {

    @Autowired
    private IMailProperties properties;

    private final Session session;

    public MailConfiguration(ObjectProvider<Session> sessionProvider) {
        this.session = sessionProvider.getIfAvailable();
    }

    @Bean
    @ConditionalOnMissingBean
    public IMailProperties mailProperties(){
        return new DefaultMailProperties();
    }

    @Bean
    @ConditionalOnMissingBean
    public MailSenderService mailSenderService(){
        return new MailSenderServiceImpl(mailSender());
    }


    @Bean(name = "javaMailSender")
    public JavaMailSender mailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        if(this.session != null){
            mailSender.setSession(session);
        }else {
            applyProperties(mailSender);
        }
        return mailSender;
    }

    private void applyProperties(JavaMailSenderImpl sender) {
        sender.setHost(this.properties.getHost());
        if (this.properties.getPort() != null) {
            sender.setPort(this.properties.getPort());
        }
        sender.setUsername(this.properties.getUsername());
        sender.setPassword(this.properties.getPassword());
        sender.setProtocol(this.properties.getProtocol());

        if (this.properties.DEFAULT_CHARSET != null) {
            sender.setDefaultEncoding(this.properties.DEFAULT_CHARSET.name());
        }
        if (this.properties.getProperties() != null && !this.properties.getProperties().isEmpty()) {
            sender.setJavaMailProperties(asProperties(this.properties));
        }
    }

    private Properties asProperties(IMailProperties source) {
        Properties properties = new Properties();
        properties.putAll(source.getProperties());
        properties.put("mail.smtp.auth",source.isAuth());
        return properties;
    }
}
