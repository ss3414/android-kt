package com.example.kotlindemo.archive

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.kotlindemo.R
import okhttp3.OkHttpClient
import okhttp3.Request
import kotlin.concurrent.thread

class ArchiveActivity : ComponentActivity() {

    private val logTag: String = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_archive)

        /* 跳转 */
        val jump: Button = findViewById(R.id.jump)
        jump.setOnClickListener {
            val intent = Intent(this@ArchiveActivity, JumpActivity::class.java)
            startActivity(intent)
        }

        /* fixme 切换语言 */
        val localeButton: Button = findViewById(R.id.locale)
        localeButton.setOnClickListener {
        }

        /* 网络抓包（注意在Android中开启应用的通知） */
        val network: Button = findViewById(R.id.network)
        network.setOnClickListener {
            /* Android不允许在主线程中执行网络请求 */
            thread {
                val client = OkHttpClient.Builder()
                    .addInterceptor(ChuckerInterceptor(this))
                    .build()
                val request = Request.Builder()
                    .url("https://jsonplaceholder.typicode.com/todos/1")
                    .build()

                try {
                    val response = client.newCall(request).execute()
                    val responseBody = response.body?.string()
                    Log.d(logTag, responseBody.toString())
                } catch (e: Exception) {
                    Log.e(logTag, e.message.toString())
                }
            }
        }

        /* 权限 */
        val permission: Button = findViewById(R.id.permission)
        permission.setOnClickListener {
            val intent = Intent(this@ArchiveActivity, PermissionActivity::class.java)
            startActivity(intent)
        }

        /* WebView */
        val webview: Button = findViewById(R.id.webview)
        webview.setOnClickListener {
            val intent = Intent(this@ArchiveActivity, WebviewActivity::class.java)
            startActivity(intent)
        }

        /* Worker */
        val worker: Button = findViewById(R.id.worker)
        worker.setOnClickListener {
            val intent = Intent(this@ArchiveActivity, WorkerActivity::class.java)
            startActivity(intent)
        }
    }

}
