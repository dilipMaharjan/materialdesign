package com.learn.materialdesign.materialdesign

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.transition.Explode
import android.transition.Fade
import android.transition.Slide
import android.transition.TransitionInflater
import android.view.Window
import android.view.animation.BounceInterpolator
import kotlinx.android.synthetic.main.activity_transition.*


class TransitionActivity : AppCompatActivity() {
    var type: String? = null
    var toolbarTitle: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {

        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transition)
        init()
        window.allowEnterTransitionOverlap = false

    }

    override fun onSupportNavigateUp(): Boolean {
        finishAfterTransition()
        return true
    }

    private fun init() {
        backBtn.setOnClickListener {
            finishAfterTransition()
        }
        type = intent.extras.getString("animType")
        toolbarTitle = intent.extras.getString("toolbarTitle")

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = toolbarTitle

        when (type) {
            "explodeJava" -> {
                val enterTransition = Explode()
                enterTransition.duration = 1000
                window.enterTransition = enterTransition
            }
            "explodeXml" -> {
                val enterTransition = TransitionInflater.from(this).inflateTransition(R.transition.explode)
                window.enterTransition = enterTransition
            }
            "slideJava" -> {
                val enterTransition = Slide()
                enterTransition.duration = 1000
                enterTransition.interpolator = BounceInterpolator()
                window.enterTransition = enterTransition
            }
            "slideXml" -> {
                val enterTransition = TransitionInflater.from(this).inflateTransition(R.transition.slide)
                window.enterTransition = enterTransition
            }
            "fadeJava" -> {
                val enterTransition = Fade()
                enterTransition.duration = 1000
                enterTransition.interpolator = BounceInterpolator()
                window.enterTransition = enterTransition
            }
            "fadeXml" -> {
                val enterTransition = TransitionInflater.from(this).inflateTransition(R.transition.fade)
                window.enterTransition = enterTransition
            }
        }
    }
}
