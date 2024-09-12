package com.example.kotlindemo.first.c12

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.appcompat.widget.Toolbar
import com.example.kotlindemo.R

class C122Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c122)

        /* fixme 注意不要设置默认工具条 */
        val toolbar: Toolbar = findViewById(R.id.toolbar)
//        setSupportActionBar(toolbar)
    }
}
