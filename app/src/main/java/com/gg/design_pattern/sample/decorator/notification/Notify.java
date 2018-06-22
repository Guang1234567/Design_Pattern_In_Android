package com.gg.design_pattern.sample.decorator.notification;

public interface Notify {
    /**
     * 发送一条通知
     */
    void send();

    /**
     * 取消一条通知
     */
    void cancel();
}
