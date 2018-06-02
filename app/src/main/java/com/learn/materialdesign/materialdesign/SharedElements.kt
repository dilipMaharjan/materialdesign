package com.learn.materialdesign.materialdesign

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewAnimationUtils
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

        sharedElementLayout.setOnClickListener {
            makeCircularRevealAnimation(sharedElementLayout)
        }

        exitBtn.setOnClickListener {
            finishAfterTransition()
        }
    }

    private fun makeCircularRevealAnimation(view: View) {

        val centerX = (view.left + view.right) / 2
        val centerY = (view.top + view.bottom) / 2

        val radius = Math.max(textDesc.width, textDesc.height) * 2.0f

        if (textDesc.visibility == View.INVISIBLE) {
            textDesc.visibility = View.VISIBLE
            ViewAnimationUtils.createCircularReveal(textDesc, centerX, centerY, 0f, radius).start()
        } else {
            val reveal = ViewAnimationUtils.createCircularReveal(textDesc, centerX, centerY, radius, 0f)
            reveal.addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    textDesc.visibility = View.INVISIBLE
                }
            })
            reveal.start()
        }
    }
}
