package com.learn.materialdesign.materialdesign

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun rippleEffects(view: View) {
        startActivity(Intent(this, RippleReffectTextViews::class.java))

    }
}
