package com.example.kotlindemo.archive

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import com.example.kotlindemo.R

class WebviewActivity : ComponentActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_archive_webview)

        val webView = findViewById<WebView>(R.id.webview)
        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true /* 启用JS */
        val webViewClient: WebViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                super.onPageFinished(view, url)
            }
        }
        webView.webViewClient = webViewClient
        webView.loadUrl("http://bbs.wuyou.net")
    }
}
