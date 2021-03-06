package com.moh.mohhtun.dailyworkout.alarm;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.moh.mohhtun.dailyworkout.R;

public class AlarmReceiver extends BroadcastReceiver {

    private static final int MY_NOTIFICATION_ID=1;
    NotificationManager notificationManager;
    Notification myNotification;
    private final String myBlog = "Time to workout";

    @Override
    public void onReceive(Context context, Intent intent) {

        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(myBlog));
        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                context,
                0,
                myIntent,
                0);


        myNotification = new NotificationCompat.Builder(context)
                .setContentTitle("WorkOUt Notification!")
                .setContentText("Time to Workout")
                .setTicker("WorkOUt Notification!")
                .setWhen(System.currentTimeMillis())
                .setContentIntent(pendingIntent)
                .setDefaults(Notification.DEFAULT_SOUND)
                .setAutoCancel(true)
                .setSmallIcon(R.drawable.alarm2)
                .build();

        notificationManager =
                (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(MY_NOTIFICATION_ID, myNotification);
    }
}
