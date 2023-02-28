package com.example.projectfoodtracker.presentation.ui.notification

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.projectfoodtracker.R
import dagger.hilt.android.AndroidEntryPoint

const val notificationID = 1
const val channelID = "channel1"
const val titleExtra = "titleExtra"
const val messageExtra = "messageExtra"

@AndroidEntryPoint
class Notification : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        Log.e("TAG", "onReceive: ")
        context?.let {
            val notification = NotificationCompat.Builder(it, channelID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle(intent?.getStringExtra(titleExtra))
                .build()

            val manager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(notificationID, notification)
        }
    }
}