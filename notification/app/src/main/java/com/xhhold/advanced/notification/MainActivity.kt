package com.xhhold.advanced.notification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var count=0
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {

            val channel = NotificationChannel("main", "test", NotificationManager.IMPORTANCE_DEFAULT)
            channel.enableLights(true)
            channel.lightColor = Color.RED
            channel.enableVibration(true)
            channel.vibrationPattern = longArrayOf(100, 100, 200)
            channel.shouldShowLights()
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)

            val builder = NotificationCompat.Builder(this, "main")
            builder.setContentTitle("测试消息")
            builder.setContentText("测试内容")
            builder.setSmallIcon(R.mipmap.ic_launcher_round)
            builder.setAutoCancel(true)
            manager.notify(++count, builder.build())
        }
    }
}
