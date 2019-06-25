package com.ecust.touhouairline.utils;

import java.util.Map;

/**
 * 创建者：李霄
 * 创建时间：2019/6/24 16:22
 * 封装了多条状态信息以及返回对象的类
 */
public class ResultWithMultiMessage<T> {
    private boolean success;
    private T object;
    private Map<String,String> messageMap;

    public ResultWithMultiMessage(boolean success, T object, Map<String,String> messageMap) {
        this.success = success;
        this.object = object;
        this.messageMap = messageMap;
    }

    public T getObject() {
        return object;
    }

    public Map<String,String> getMessage(){
        return messageMap;
    }

    public boolean isSuccess(){
        return success;
    }
}
