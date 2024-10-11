package com.example.kotlindemo.archive

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.example.kotlindemo.R
import java.util.concurrent.TimeUnit

class WorkerActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_archive_worker)

        val workManager = WorkManager.getInstance(applicationContext)
        val workTag = "WorkerDemo"

        /* 启动Worker */
        val button1: Button = findViewById(R.id.button1)
        button1.setOnClickListener {
            val duration = 0L /* 初始间隔 */
            val request: PeriodicWorkRequest = PeriodicWorkRequest.Builder(WorkerDemo::class.java, 1, TimeUnit.DAYS)
                .setInitialDelay(duration, TimeUnit.MILLISECONDS)
                .addTag(workTag)
                .build()
            workManager.enqueue(request)
            Toast.makeText(this, "启动Worker", Toast.LENGTH_SHORT).show()
        }

        /* 查看WorkInfo */
        val button2: Button = findViewById(R.id.button2)
        button2.setOnClickListener {
            val workInfoList = workManager.getWorkInfosByTag(workTag).get()
            for (workInfo in workInfoList) {
                Toast.makeText(this, "id:${workInfo.id} , state:${workInfo.state}", Toast.LENGTH_SHORT).show()
            }
        }

        /* 取消Worker */
        val button3: Button = findViewById(R.id.button3)
        button3.setOnClickListener {
            workManager.cancelAllWorkByTag(workTag)
            Toast.makeText(this, "取消Worker", Toast.LENGTH_SHORT).show()
        }

        /* 清空Worker */
        val button4: Button = findViewById(R.id.button4)
        button4.setOnClickListener {
            workManager.pruneWork()
            Toast.makeText(this, "清空Worker", Toast.LENGTH_SHORT).show()
        }
    }

}
