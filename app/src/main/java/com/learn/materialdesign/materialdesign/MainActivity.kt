package com.learn.materialdesign.materialdesign

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.util.Pair
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
}
