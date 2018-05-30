package com.learn.materialdesign.materialdesign

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (checkApiLevel()) println("True") else println("False")
    }

    private fun checkApiLevel(): Boolean = Build.VERSION.SDK_INT == Build.VERSION_CODES.LOLLIPOP
}
