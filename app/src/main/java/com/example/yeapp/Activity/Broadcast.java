package com.example.yeapp.Activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.yeapp.R;

public class Broadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationCompat.Builder builder=new NotificationCompat.Builder(context,"notifyLemubit")
                .setSmallIcon(R.drawable.blue_button)
                .setContentTitle("Siparişi Ver")
                .setContentText("Siparişi vermezsen unutabilirsin...")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManagerCompat= NotificationManagerCompat.from(context);
        notificationManagerCompat.notify(200,builder.build());

    }
}
