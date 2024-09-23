package com.example.kotlindemo.first.c03

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity

class C31Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = intent
        Toast.makeText(this, intent.getStringExtra("data"), Toast.LENGTH_SHORT).show()
    }
}
