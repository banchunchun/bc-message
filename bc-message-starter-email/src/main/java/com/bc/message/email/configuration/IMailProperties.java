package com.bc.message.email.configuration;

import java.nio.charset.Charset;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: banchun
 * Date:  2017-05-15
 * Time:  上午 11:23.
 * Description:
 * To change this template use File | Settings | File Templates.
 */
public interface IMailProperties {

    Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
    String          getHost();
    Integer         getPort();
    String          getUsername();
    String          getPassword();
    String          getProtocol();
    boolean         isTestConnection();
    boolean         isAuth();
    Map<String,String> getProperties();
}
