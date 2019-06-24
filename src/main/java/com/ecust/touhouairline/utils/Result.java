package com.ecust.touhouairline.utils;


public class Result<T> {
    private boolean success;
    private T object;

    public Result(boolean success, T object) {
        this.success = success;
        this.object = object;
    }

    public T getObject() {
        return object;
    }

    public boolean isSuccess(){
        return success;
    }
}
