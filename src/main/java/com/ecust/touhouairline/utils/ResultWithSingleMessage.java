package com.ecust.touhouairline.utils;

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
