package com.example.kotlindemo.first.c07

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.kotlindemo.R
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class C72Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c072)

        /* 存储文件 */
        val button1: Button = findViewById(R.id.button1)
        button1.setOnClickListener {
            try {
                val output = openFileOutput("data", Context.MODE_PRIVATE)
                val writer = BufferedWriter(OutputStreamWriter(output))
                writer.use {
                    it.write("C72Activity")
                }
                Toast.makeText(this, "存储文件", Toast.LENGTH_SHORT).show()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

        /* 读取文件 */
        val button2: Button = findViewById(R.id.button2)
        button2.setOnClickListener {
            val content = StringBuilder()
            try {
                val input = openFileInput("data")
                val reader = BufferedReader(InputStreamReader(input))
                reader.use {
                    reader.forEachLine {
                        content.append(it)
                    }
                }
                Toast.makeText(this, content, Toast.LENGTH_SHORT).show()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}
