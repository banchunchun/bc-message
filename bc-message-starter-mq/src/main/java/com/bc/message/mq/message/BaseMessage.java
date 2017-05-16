package com.bc.message.mq.message;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: banchun
 * Date:  2017-05-15
 * Time:  下午 9:32.
 * Description:
 * To change this template use File | Settings | File Templates.
 */
public abstract class BaseMessage<T> implements Serializable{

    protected String key; //自定义key

    protected String tag; //自定义标记

    protected  T  clazz; //消息体

    public BaseMessage(){

    }

    public BaseMessage(String key,String tag,T obj){
        this.key = key;
        this.tag = tag;
        this.clazz = obj;
    }


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public T getClazz() {
        return clazz;
    }

    public void setClazz(T clazz) {
        this.clazz = clazz;
    }



    @Override
    public int hashCode() {
        int result = tag.hashCode();
        result = 31 * result + key.hashCode();
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (null == obj)
            return false;
        if (this == obj)
            return true;
        if (!(obj instanceof BaseMessage))
            return false;
        BaseMessage message = (BaseMessage) obj;
        if (!message.getTag().equals(this.getTag()))
            return false;
        return message.getKey().equals(this.getKey());
    }
}
