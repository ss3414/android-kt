package com.example.kotlindemo.archive

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class WorkerDemo(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    override fun doWork(): Result {
        return Result.success()
    }

}
