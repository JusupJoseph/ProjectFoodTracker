package com.example.projectfoodtracker.presentation.ui.notification

import android.app.*
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.projectfoodtracker.R
import com.example.projectfoodtracker.databinding.FragmentNotificationBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class NotificationFragment : Fragment(R.layout.fragment_notification) {

    private val binding by viewBinding(FragmentNotificationBinding::bind)

    @Deprecated("Deprecated in Java")
    override fun onAttach(context: Context) {
        super.onAttach(context)
        creatNotificationChannel()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListener()
    }

    private fun setupListener() {
        binding.btnPush.setOnClickListener {
            schedulNotiffication()
        }
    }

    private fun schedulNotiffication() {
        val intent = Intent(context?.applicationContext, Notification::class.java)
        val title = binding.text.text.toString()
        val message = binding.message.text.toString()
        intent.putExtra(titleExtra, title)

        val pendingIntent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            PendingIntent.getBroadcast(
                context?.applicationContext,
                notificationID,
                intent,
                PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
            )
        } else {
            TODO("VERSION.SDK_INT < M")
        }
        val alarmManager =
            context?.applicationContext?.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val time = getTime()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarmManager.setExactAndAllowWhileIdle(
                AlarmManager.RTC_WAKEUP,
                time,
                pendingIntent
            )
        }
        showAlert(time, title, message)
    }

    private fun showAlert(time: Long, title: Any, message: String) {
        val date = Date(time)
        val dateFormat =
            android.text.format.DateFormat.getLongDateFormat(context?.applicationContext)
        val timeFormat = android.text.format.DateFormat.getTimeFormat(context?.applicationContext)

        AlertDialog.Builder(requireActivity())
            .setTitle("Notification Scheduled")
            .setMessage(
                "Title: " + title +
                        "\nMessage: " + message +
                        "\nAt: " + dateFormat.format(date) + " " + timeFormat.format(
                    date
                )
            ).setPositiveButton("okey") { _, _ -> }
            .show()
    }

    private fun getTime(): Long {
        val minute = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            binding.timePicker.minute
        } else {
            TODO("VERSION.SDK_INT < M")
        }
        val hour = binding.timePicker.hour
        val day = binding.datePicker.dayOfMonth
        val month = binding.datePicker.month
        val year = binding.datePicker.year
        val calendar = Calendar.getInstance()
        calendar.set(year, month, day, hour, minute)
        return calendar.timeInMillis
    }

    private fun creatNotificationChannel() {
        val name = "Notif Channel"
        val desc = "A description of the Channel"
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelID, name, importance)
            channel.description = desc
            val notificationManager =
                requireContext().getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}