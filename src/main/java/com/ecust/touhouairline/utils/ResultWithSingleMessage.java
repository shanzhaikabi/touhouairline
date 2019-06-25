package com.ecust.touhouairline.utils;

/**
 * 创建者：李霄
 * 创建时间：2019/6/24 16:22
 * 封装了单条状态信息和一个返回对象的类
 */
public class ResultWithSingleMessage<T> {
    private boolean success;
    private T object;
    private String message;

    public ResultWithSingleMessage(boolean success, T object,String message) {
        this.success = success;
        this.object = object;
        this.message = message;
    }

    public T getObject() {
        return object;
    }

    public String getMessage(){
        return message;
    }

    public boolean isSuccess(){
        return success;
    }
}
