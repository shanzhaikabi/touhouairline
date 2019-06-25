package com.ecust.touhouairline.utils;

import java.util.Map;

/**
 * 创建者：李霄
 * 创建时间：2019/6/24 16:22
 * 封装了多条状态信息的类，不包含返回对象
 */
public class MultiMessageResult {
    private boolean success;
    private Map<String,String> messageMap;

    public MultiMessageResult(boolean success, Map<String, String> messageMap) {
        this.success = success;
        this.messageMap = messageMap;
    }

    public boolean isSuccess() {
        return success;
    }

    public Map<String, String> getMessageMap() {
        return messageMap;
    }
}
