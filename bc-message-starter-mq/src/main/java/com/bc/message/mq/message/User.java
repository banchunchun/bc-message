package com.bc.message.mq.message;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: banchun
 * Date:  2017-05-15
 * Time:  下午 9:49.
 * Description:
 * To change this template use File | Settings | File Templates.
 */
public class User implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
