package com.example.kotlindemo.archive

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity

class JumpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        /* 根据包名打开其他App */
//        val packageName = "com.android.camera"
//        val intent = packageManager.getLaunchIntentForPackage(packageName)
//        if (intent != null) {
//            startActivity(intent)
//        } else {
//            Toast.makeText(this, "包名没找到", Toast.LENGTH_SHORT).show()
//        }

        /* 根据DeepLink打开其他App */
        val deepLink = "twitter://user?screen_name=partizan_oleg"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(deepLink))
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK) /* 新开目标应用 */
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "应用未安装", Toast.LENGTH_SHORT).show()
        }
    }
}
