package com.bootcounter

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.bootcounter.utils.Constants.GENERAL_NOTIFICATION_CHANNEL_ID
import com.bootcounter.utils.Constants.BOOT_NOTIFICATION_ID

class BootWorkManager(private val context: Context, private val workerParams: WorkerParameters) :
    CoroutineWorker(context, workerParams) {

    private val notifyBuilder: NotificationCompat.Builder =
        NotificationCompat.Builder(context, GENERAL_NOTIFICATION_CHANNEL_ID)

    private val mNotifyManager: NotificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    init {
        if (buildIsAtLeastOreo()) {
            val channel = NotificationChannel(
                GENERAL_NOTIFICATION_CHANNEL_ID,
                context.getString(R.string.default_notification_channel_name),
                NotificationManager.IMPORTANCE_LOW
            )
            mNotifyManager.createNotificationChannel(channel)
        }
    }


    override suspend fun doWork(): Result {
        TODO("Get data from database about boot complete")
        val title = ""
        val data = ""
        showNotification(title, data)

    }

    private fun showNotification(title: String, contentDescription: String) {
        notifyBuilder.setContentTitle(title)
            .setContentText(contentDescription)
            .setOngoing(true)
        mNotifyManager.notify(BOOT_NOTIFICATION_ID, notifyBuilder.build())
    }

    private fun buildIsAtLeastOreo(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.O
    }
}
