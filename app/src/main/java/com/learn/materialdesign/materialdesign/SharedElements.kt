package com.learn.materialdesign.materialdesign

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Window
import kotlinx.android.synthetic.main.activity_shared_elements.*


class SharedElements : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_elements)

        initPage()
    }

    override fun onSupportNavigateUp(): Boolean {
        finishAfterTransition()
        return true
    }

    fun initPage() {
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = "Shared Element Transition"
        exitBtn.setOnClickListener {
            finishAfterTransition()
        }
    }
}
