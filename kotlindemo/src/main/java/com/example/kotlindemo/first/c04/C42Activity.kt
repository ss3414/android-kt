package com.example.kotlindemo.first.c04

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.kotlindemo.R

class C42Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c042)

        val editText: EditText = findViewById(R.id.edittext)
        editText.setOnKeyListener { _: View?, actionId: Int, event: KeyEvent ->
            /* 监听回车 */
            if (actionId == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                Toast.makeText(this, editText.text, Toast.LENGTH_SHORT).show()
                return@setOnKeyListener true
            } else {
                return@setOnKeyListener false
            }
        }
    }
}
