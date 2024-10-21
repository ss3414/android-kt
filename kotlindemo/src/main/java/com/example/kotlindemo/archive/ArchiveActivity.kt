package com.example.kotlindemo.archive

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.example.kotlindemo.R

class ArchiveActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_archive)

        /* 跳转 */
        val jump: Button = findViewById(R.id.jump)
        jump.setOnClickListener {
            val intent = Intent(this@ArchiveActivity, JumpActivity::class.java)
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
