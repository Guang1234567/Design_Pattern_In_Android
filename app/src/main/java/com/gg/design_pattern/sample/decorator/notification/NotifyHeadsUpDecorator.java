package com.gg.design_pattern.sample.decorator.notification;

import android.app.Application;
import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.widget.RemoteViews;

import com.gg.design_pattern.sample.R;

public class NotifyHeadsUpDecorator extends BaseNotifyDecorator {

    public NotifyHeadsUpDecorator(BaseNotify notify, NotificationManager notifiMgr, Application application) {
        super(notify, notifiMgr, application);
    }

    @Override
    protected NotificationCompat.Builder createNotifiBuilder() {
        Context context = mApplication;
        NotificationCompat.Builder builder = super.createNotifiBuilder();
        RemoteViews remoteViews = builder.getContentView();
        remoteViews.setTextViewText(R.id.remote_content, "NotifyHeadsUpDecorator");
        builder.setCustomHeadsUpContentView(remoteViews);
        return builder;
    }
}
