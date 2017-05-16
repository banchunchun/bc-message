package com.bc.message.web;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.StopWatch;

import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: banchun
 * Date:  2017-05-16
 * Time:  下午 7:18.
 * Description:
 * To change this template use File | Settings | File Templates.
 */

@SpringBootApplication
public class AppRunner implements CommandLineRunner {
    private static Logger logger = Logger.getLogger(AppRunner.class.getName());

    public static void main(String[] args) {
        StopWatch watch = new StopWatch("UserServiceApp");

        watch.start("SpringApplication");
        SpringApplication application = new SpringApplication(AppRunner.class);
        watch.stop();

        watch.start("AddListeners");
//        application.addListeners(new ApplicationListenerPrepared());
//        application.addListeners(new ApplicationListenerEnvironmentPrepared());
//        application.addListeners(new ApplicationListenerFailed());
        watch.stop();

        watch.start("Settings");
        application.setRegisterShutdownHook(true);
        application.setWebEnvironment(true);
        watch.stop();

        watch.start("Running");
        application.run(args);
        watch.stop();

        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                logger.info("******************************bc-message-web shutdown******************************");
            }
        });

        logger.info(watch.prettyPrint());
    }

    @Override
    public void run(String... strings) throws Exception {
        logger.warning("******************************bc-message-web startup******************************");
    }
}
