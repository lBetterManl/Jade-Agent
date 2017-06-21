package com.yhc.gateway;

import java.io.Serializable;

/**
 * Created by hp on 2017/6/20.
 *
 * Gateway Agent 和 Servlet 交互黑板
 */
public class DataChannel implements Serializable {
    private String message;
    private String recevier;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRecevier() {
        return recevier;
    }

    public void setRecevier(String recevier) {
        this.recevier = recevier;
    }

    public DataChannel() {
    }

    public DataChannel(String message, String recevier) {
        this.message = message;
        this.recevier = recevier;
    }

    @Override
    public String toString() {
        return "DataChannel{" +
                "message='" + message + '\'' +
                ", recevier='" + recevier + '\'' +
                '}';
    }
}
