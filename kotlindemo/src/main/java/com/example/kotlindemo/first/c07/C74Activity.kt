package com.example.kotlindemo.first.c07

import android.annotation.SuppressLint
import android.content.ContentValues
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.kotlindemo.R

class C74Activity : ComponentActivity() {
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c074)

        /* 创建数据库 */
        val util = SQLiteUtil(this, "untitled.db", 1)
        val button1: Button = findViewById(R.id.button1)
        button1.setOnClickListener {
            util.writableDatabase
        }

        /* 更新数据库 */
        val util2 = SQLiteUtil(this, "untitled.db", 2) /* 通过更新添加新表 */
        val button2: Button = findViewById(R.id.button2)
        button2.setOnClickListener {
            util2.writableDatabase
        }

        /* 添加数据 */
        val button3: Button = findViewById(R.id.button3)
        button3.setOnClickListener {
            val database = util.writableDatabase
            val values = ContentValues()
            values.put("name", "name123")
            values.put("password", "pwd123")
            database.insert("user", null, values)
        }

        /* 更新数据 */
        val button4: Button = findViewById(R.id.button4)
        button4.setOnClickListener {
            val database = util.writableDatabase
            val values = ContentValues()
            values.put("password", "pwd456")
            database.update("user", values, "name=?", arrayOf("name123"))
        }

        /* 删除数据 */
        val button5: Button = findViewById(R.id.button5)
        button5.setOnClickListener {
            val database = util.writableDatabase
            database.delete("user", "name=?", arrayOf("name123"))
        }

        /* 查询数据 */
        val button6: Button = findViewById(R.id.button6)
        button6.setOnClickListener {
            val database = util.writableDatabase
            val cursor = database.query("user", null, null, null, null, null, null)
            if (cursor.moveToFirst()) {
                do {
                    val name = cursor.getString(cursor.getColumnIndex("name"))
                    Toast.makeText(this, name, Toast.LENGTH_SHORT).show()
                } while (cursor.moveToNext())
            }
            cursor.close()
        }
    }
}
