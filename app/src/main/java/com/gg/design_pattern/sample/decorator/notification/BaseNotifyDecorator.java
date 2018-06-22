package com.gg.design_pattern.sample.decorator.notification;

import android.app.Application;
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;

public abstract class BaseNotifyDecorator extends BaseNotify {
    private BaseNotify mNotify;

    public BaseNotifyDecorator(BaseNotify notify, NotificationManager notifiMgr, Application application) {
        super(notifiMgr, application);
        mNotify = notify;
    }

    @Override
    protected NotificationCompat.Builder createNotifiBuilder() {
        return mNotify.createNotifiBuilder();
    }
}
