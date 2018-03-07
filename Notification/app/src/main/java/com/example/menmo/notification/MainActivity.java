package com.example.menmo.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sendNotice = (Button) findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send_notice:
                Intent intent = new Intent(this, NotificationActivity.class);
                PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification notification = new NotificationCompat.Builder(this)
                        .setContentTitle("This is content title")
                        .setContentText("Learn how to build notifications,send and sync data,and use voice actions," +
                                "Get the official Android IDE and developer tools to build apps for Android.")//通知信息
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                        .setContentIntent(pi)
                        .setAutoCancel(true)//显示调用NotificationManager的cancel()方法
                        .setSound(Uri.fromFile(new File("/storage/emulated/0/1/Westlife - Soledad.mp3")))
                        //通知发出时播放一段音频
                        .setVibrate(new long[]{0, 1000, 1000, 1000})//在通知的时候让手机震动1秒 静1秒 震动1秒 静1秒
                        .setLights(Color.GREEN, 1000, 1000)//在通知的时候让呼吸灯一闪一闪
                        .setDefaults(NotificationCompat.DEFAULT_ALL)//直接使用通知的默认效果
                        //.setStyle(new NotificationCompat.BigTextStyle().bigText("Learn how to build notifications,send and sync data," +
                        //       "and use voice actions,Get the official Android IDE and developer tools to build apps for Android."))
                        //调用bigText()将通知内容传入到页面内容
                        .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.big_image)))
                        //发送通知时传入图片
                        .setPriority(NotificationCompat.PRIORITY_MAX)
                        .build();
                manager.notify(1, notification);
                break;
            default:
                break;
        }
    }
}
