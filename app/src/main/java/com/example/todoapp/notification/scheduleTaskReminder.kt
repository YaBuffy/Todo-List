package com.example.todoapp.notification

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Settings
import com.example.todoapp.tasksDb.model.TaskEntity

fun scheduleTaskReminder(context: Context, task: TaskEntity ){
    val intent = Intent(context, TaskReminderReceiver::class.java).apply {
        putExtra("task_title", task.title)
        putExtra("task_description", task.description)
    }
    val pendingIntent = PendingIntent.getBroadcast(
        context,
        task.id,
        intent,
        PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
    )
    val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

    val triggerTime = task.dateTime - 10 * 60 * 1000

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S && !alarmManager.canScheduleExactAlarms()) {
        val intentSettings = Intent(Settings.ACTION_REQUEST_SCHEDULE_EXACT_ALARM).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }
        context.startActivity(intentSettings)
        return
    }

    alarmManager.setExactAndAllowWhileIdle(
        AlarmManager.RTC_WAKEUP,
        triggerTime,
        pendingIntent
    )
}