package com.example.yeapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.yeapp.R;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Button button = (Button) findViewById(R.id.button3);
        createNotificationChanel();
        button.setOnClickListener(v -> {
            Toast.makeText(this, "Bildirim Modu Açık", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ProfileActivity.this, Broadcast.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(ProfileActivity.this, 0, intent, PendingIntent.FLAG_MUTABLE);

            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

            long timeAt = System.currentTimeMillis();
            long saniye = 1000 * 5;
            alarmManager.set(AlarmManager.RTC_WAKEUP, timeAt + saniye, pendingIntent);
        });
    }

    private void createNotificationChanel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "LemubitReminderChannel";
            String description = "Channel for Lemubit Reminder";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("notifyLemubit", name, importance);
            channel.setDescription(description);


            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}