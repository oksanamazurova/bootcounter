package com.bootcounter.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.bootcounter.BootWorkManager
import com.bootcounter.R
import com.bootcounter.utils.Constants.UNIQUE_BOOT_WORKER_NAME
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initCheckBootWorker()
    }

    private fun initCheckBootWorker() {
        val checkBootRequest =
            PeriodicWorkRequest.Builder(BootWorkManager::class.java, 15, TimeUnit.MINUTES).build()
        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
            UNIQUE_BOOT_WORKER_NAME, ExistingPeriodicWorkPolicy.KEEP, checkBootRequest
        )
    }
}