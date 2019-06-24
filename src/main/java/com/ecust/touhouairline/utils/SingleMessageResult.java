package com.ecust.touhouairline.utils;

/**
 * 创建者：李霄
 * 创建时间：2019/6/24 16:22
 * 封装了单条状态信息的类，不包含返回对象
 */
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
