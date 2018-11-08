package com.example.mike.week3daily3.services;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaBrowserServiceCompat;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaButtonReceiver;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.style.ForegroundColorSpan;
import android.util.Log;

import com.example.mike.week3daily3.R;

import java.io.IOException;
import java.util.List;

import static android.app.Notification.EXTRA_NOTIFICATION_ID;

public class PlayerService extends Service {

    public static final String TAG="__TAG__";

    private static final String FILE_LOCATION="don_mclean_american_pie.mp3";
    public static final String ACTION_STOP="week3daily3.app.action.STOP";
    public static final String ACTION_PAUSE="week3daily3.app.action.PAUSE";
    public static final String ACTION_PLAY="week3daily3.app.action.PLAY";


    private MediaPlayer mediaPlayer;
    private MyBroadcastReceiver myBroadcastReceiver;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @SuppressLint("NewApi")
    @Override
    public void onCreate() {
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }



    public class MyBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "onReceive: action="+intent.getAction());
        }

    }

}
