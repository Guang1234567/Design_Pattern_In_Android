package com.gg.design_pattern.sample.decorator.notification;

import android.app.Application;
import android.app.NotificationManager;
import android.os.Build;

public class NotifyProxy implements Notify {

    private Notify notifyDecorator;

    public NotifyProxy(NotificationManager notifiMgr, Application application) {
        BaseNotify notify = new NotifyNormal(notifiMgr, application);
        NotifyNormalDecorator notifyNormalDecorator = new NotifyNormalDecorator(notify, notifiMgr, application);
        NotifyBigDecorator notifyBigDecorator = new NotifyBigDecorator(notifyNormalDecorator, notifiMgr, application);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            notifyDecorator = new NotifyHeadsUpDecorator(
                    notifyBigDecorator, notifiMgr, application
            );
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            notifyDecorator = notifyBigDecorator;
        } else {
            notifyDecorator = notifyNormalDecorator;
        }
    }

    @Override
    public void send() {
        notifyDecorator.send();
    }

    @Override
    public void cancel() {
        notifyDecorator.cancel();
    }
}
