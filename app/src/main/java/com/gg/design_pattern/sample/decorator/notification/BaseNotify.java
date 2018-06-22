package com.gg.design_pattern.sample.decorator.notification;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;

abstract class BaseNotify implements Notify {

    protected Application mApplication;
    protected NotificationManager mNotificationManager;

    public BaseNotify(NotificationManager notifiMgr, Application application) {
        mNotificationManager = notifiMgr;
        mApplication = application;
    }

    protected abstract NotificationCompat.Builder createNotifiBuilder();

    @Override
    final public void send() {
        Notification notification = createNotifiBuilder().build();
        mNotificationManager.notify(0, notification);
    }

    @Override
    final public void cancel() {
        mNotificationManager.cancel(0);
    }
}
