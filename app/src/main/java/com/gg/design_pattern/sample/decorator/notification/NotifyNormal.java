package com.gg.design_pattern.sample.decorator.notification;

import android.app.Application;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.gg.design_pattern.sample.NotifyActivity;
import com.gg.design_pattern.sample.R;

public class NotifyNormal extends BaseNotify {


    public NotifyNormal(NotificationManager notifiMgr, Application application) {
        super(notifiMgr, application);
    }

    @Override
    protected NotificationCompat.Builder createNotifiBuilder() {
        Context context = mApplication;
        return new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentIntent(PendingIntent.getActivity(context, 0,
                        new Intent(context, NotifyActivity.class),
                        PendingIntent.FLAG_UPDATE_CURRENT));
    }
}
