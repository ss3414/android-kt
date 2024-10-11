package com.example.kotlindemo.first.c05

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.kotlindemo.R

/* 需要继承FragmentActivity */
class C52Activity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_c052)
    }
}
