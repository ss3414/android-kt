package com.example.kotlindemo.archive

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat

class PermissionActivity : ComponentActivity() {

    private lateinit var requestPermissionLauncher: ActivityResultLauncher<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
                Toast.makeText(this, "获得网络访问权限", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "未获得网络访问权限", Toast.LENGTH_SHORT).show()
            }
        }

        checkInternetPermission()
    }

    /* 检查网络权限（无权限请求，有权限提示） */
    private fun checkInternetPermission() {
        when {
            ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED -> {
                Toast.makeText(this, "已获得网络访问权限", Toast.LENGTH_SHORT).show()
            }

            else -> {
                /* 请求权限（注意对这个请求结果的处理是上面的registerForActivityResult） */
                requestPermissionLauncher.launch(Manifest.permission.INTERNET)
            }
        }
    }

}
