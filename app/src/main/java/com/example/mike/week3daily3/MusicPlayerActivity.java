package com.example.mike.week3daily3;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.mike.week3daily3.services.PlayerService;

import java.io.IOException;

public class MusicPlayerActivity extends AppCompatActivity {

    public static final String TAG = "__TAG__";
    public static final int CHANNEL_ID = 1;
    public static final String ACTION_STOP = "stop";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);
        Log.d(TAG, "onCreate: ");
    }

    @SuppressLint("NewApi")
    public void play(View view){

        // STop button
        Intent stopIntent = new Intent( this, MusicPlayerActivity.class);
        stopIntent.setAction( ACTION_STOP );
        PendingIntent stopPendingIntent = PendingIntent.getActivity(this, 0, stopIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Action stopAction = new NotificationCompat.Action(0,"Stop", stopPendingIntent);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, String.valueOf(CHANNEL_ID))
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Title")
                .setContentText("Text")
                .addAction(stopAction)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Channel name";
            String description = "Channel description";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(String.valueOf(CHANNEL_ID), name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        //NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify( 0, mBuilder.build() );
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(TAG, "onNewIntent: ");
    }
}
