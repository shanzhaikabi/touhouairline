package com.ecust.touhouairline.utils;

import java.util.Map;

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
