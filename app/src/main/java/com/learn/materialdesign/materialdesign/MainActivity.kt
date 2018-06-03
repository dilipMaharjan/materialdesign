package com.learn.materialdesign.materialdesign

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.transition.Slide
import android.util.Pair
import android.view.Gravity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val slide = Slide()
        slide.slideEdge = Gravity.RIGHT
        window.reenterTransition = slide
        window.allowReturnTransitionOverlap = false
    }

    fun rippleEffects(view: View) {
        startActivity(Intent(this, RippleReffectTextViews::class.java))
    }

    fun sharedElements(view: View) {
        val pair = arrayOfNulls<Pair<View, String>>(3)
        pair[0] = Pair(sharedLeftStar, "sharedLeftStar")
        pair[1] = Pair(sharedRightStar, "sharedRightStar")
        pair[2] = Pair(sharedText, "sharedText")

        val options = ActivityOptions.makeSceneTransitionAnimation(this, *pair)
        val i = Intent(this@MainActivity, SharedElements::class.java)
        startActivity(i, options.toBundle())
    }

    fun explodeAnimByCode(view: View) {
        animate("explodeJava", "Explode Java")
    }

    fun explodeAnimByXml(view: View) {
        animate("explodeXml", "Explode Xml")
    }

    fun slideAnimByCode(view: View) {
        animate("slideJava", "Slide Java")
    }

    fun slideAnimByXml(view: View) {
        animate("slideXml", "Slide Xml")
    }

    fun fadeAnimByCode(view: View) {
        animate("fadeJava", "Fade Java")
    }

    fun fadeAnimByXml(view: View) {
        animate("fadeXml", "Fade Xml")
    }


    private fun animate(type: String, title: String) {
        val options = ActivityOptions.makeSceneTransitionAnimation(this)

        val intent = Intent(this, TransitionActivity::class.java)
        intent.putExtra("animType", type)
        intent.putExtra("toolbarTitle", title)
        startActivity(intent, options.toBundle())
    }
}
