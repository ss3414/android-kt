package com.example.kotlindemo.first

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity
import com.example.kotlindemo.R
import com.example.kotlindemo.first.c03.C31Activity
import com.example.kotlindemo.first.c04.C42Activity
import com.example.kotlindemo.first.c04.C43Activity
import com.example.kotlindemo.first.c05.C52Activity
import com.example.kotlindemo.first.c07.C72Activity
import com.example.kotlindemo.first.c07.C73Activity
import com.example.kotlindemo.first.c07.C74Activity
import com.example.kotlindemo.first.c12.C122Activity

class FirstActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        /* Log+logcat才能看到日志 */
        Log.d("FirstActivity", "create")

        /* 活动 */
        val c31: Button = findViewById(R.id.c31)
        c31.setOnClickListener {
            val intent = Intent(this@FirstActivity, C31Activity::class.java)
            /* 通过Intent传输数据 */
            intent.putExtra("data", "str")
            startActivity(intent)
        }

        /* 控件 */
        val c42: Button = findViewById(R.id.c42)
        c42.setOnClickListener {
            val intent = Intent(this@FirstActivity, C42Activity::class.java)
            startActivity(intent)
        }

        /* 布局 */
        val c43: Button = findViewById(R.id.c43)
        c43.setOnClickListener {
            val intent = Intent(this@FirstActivity, C43Activity::class.java)
            startActivity(intent)
        }

        /* Fragment（适配平板） */
        val c52: Button = findViewById(R.id.c52)
        c52.setOnClickListener {
            val intent = Intent(this@FirstActivity, C52Activity::class.java)
            startActivity(intent)
        }

        /* 文件存储 */
        val c72: Button = findViewById(R.id.c72)
        c72.setOnClickListener {
            val intent = Intent(this@FirstActivity, C72Activity::class.java)
            startActivity(intent)
        }

        /* SharedPreferences */
        val c73: Button = findViewById(R.id.c73)
        c73.setOnClickListener {
            val intent = Intent(this@FirstActivity, C73Activity::class.java)
            startActivity(intent)
        }

        /* SQLite */
        val c74: Button = findViewById(R.id.c74)
        c74.setOnClickListener {
            val intent = Intent(this@FirstActivity, C74Activity::class.java)
            startActivity(intent)
        }

        /* ToolBar */
        val c122: Button = findViewById(R.id.c122)
        c122.setOnClickListener {
            val intent = Intent(this@FirstActivity, C122Activity::class.java)
            startActivity(intent)
        }
    }
}
