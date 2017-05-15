package com.bc.message.email.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: banchun
 * Date:  2017-05-15
 * Time:  上午 11:24.
 * Description:
 * To change this template use File | Settings | File Templates.
 */
@ConfigurationProperties(prefix = "message.mail")
public class DefaultMailProperties implements IMailProperties {

    private String host;
    private Integer port;
    private String username;
    private String password;
    private String protocol;
    private boolean testConnection;
    private boolean auth;
    private Map<String, String> properties;

    @Override
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @Override
    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    @Override
    public boolean isTestConnection() {
        return testConnection;
    }

    public void setTestConnection(boolean testConnection) {
        this.testConnection = testConnection;
    }

    @Override
    public boolean isAuth() {
        return auth;
    }

    public void setAuth(boolean auth) {
        this.auth = auth;
    }

    @Override
    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }
}
