package com.example.kotlindemo.archive

import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity

class DeepLinkActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /* 解析DeepLink中的参数 */
        /* adb shell am start -W -a android.intent.action.VIEW -d "demo://example.com/main" com.example.kotlindemo */
        val intent = intent
        val uri: Uri? = intent.data
        if (uri != null) {
            val id = uri.getQueryParameter("id")
            Toast.makeText(this, "id: $id", Toast.LENGTH_SHORT).show()
        }
    }
}
