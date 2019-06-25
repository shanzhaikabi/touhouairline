package com.ecust.touhouairline.utils;

/**
 * 创建者：李霄
 * 创建时间：2019/6/24 16:22
 * 封装了返回对象的类，不包含状态信息
 */
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
