package com.example.projectfoodtracker.presentation

import android.app.Notification
import android.app.Notification.BigTextStyle
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.projectfoodtracker.R
import com.example.projectfoodtracker.presentation.ui.activity.MainActivity
import com.example.projectfoodtracker.presentation.ui.fragments.MainFragment

class CounterNotificationService(
    private val context: Context
) {
    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    fun showNotification(counter: Int){
        val intent = Intent(context, MainFragment::class.java)
        val activityPendingIntent = PendingIntent.getActivity(
            context,
            1,
            intent,
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0
        )
        val incrementIntent = PendingIntent.getBroadcast(
            context,
            2,
            Intent(context, CounterNotificationReceiver::class.java),
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0

        )
        val notification = NotificationCompat.Builder(context, COUNTER_CHANNEL_ID)
            .setSmallIcon(R.drawable.img_one)
            .setContentTitle("OBEEEDD")
            .setContentText("PORA KUSHAT$counter")
            .setContentIntent(activityPendingIntent)
            .addAction(
                R.drawable.img_one,
                "test",
                incrementIntent
            )
            .build()

        notificationManager.notify(
            1,
            notification
        )

    }



    companion object {
        const val COUNTER_CHANNEL_ID = "counter_channel"
    }

}