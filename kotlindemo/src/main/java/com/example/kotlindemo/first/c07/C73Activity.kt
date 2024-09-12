package com.example.kotlindemo.first.c07

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.kotlindemo.R

class C73Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c073)

        /* 添加数据 */
        val button1: Button = findViewById(R.id.button1)
        button1.setOnClickListener {
            val preferences = getSharedPreferences("data", MODE_PRIVATE)
            var count = preferences.getInt("count", 0)
            Toast.makeText(this, "获取数据:$count", Toast.LENGTH_SHORT).show()
            val editor = getSharedPreferences("data", MODE_PRIVATE).edit()
            count += 1
            editor.putInt("count", count)
            editor.apply()
            Toast.makeText(this, "添加数据", Toast.LENGTH_SHORT).show()
        }

        /* 获取数据 */
        val button2: Button = findViewById(R.id.button2)
        button2.setOnClickListener {
            val preferences = getSharedPreferences("data", MODE_PRIVATE)
            Toast.makeText(this, "获取数据:" + preferences.getInt("count", 0), Toast.LENGTH_SHORT).show()
        }
    }
}
