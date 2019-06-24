package com.ecust.touhouairline.utils;

public class SingleMessageResult {
    private boolean success;
    private String message;

    public SingleMessageResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public boolean isSuccess(){
        return success;
    }
}
