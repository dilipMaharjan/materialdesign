package com.learn.materialdesign.materialdesign

import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (checkApiLevel()) println("True") else println("False")
    }

    private fun checkApiLevel(): Boolean = Build.VERSION.SDK_INT == Build.VERSION_CODES.LOLLIPOP

    fun showStandAloneToolBar(view: View) {
        startActivity(Intent(this, StandAloneToolBar::class.java))
    }

    fun showToolBarAsActionBar(view: View) {
        startActivity(Intent(this, ToolBarAsActionBar::class.java))
    }

    fun showContextualMenu(view: View) {
        startActivity(Intent(this, ContextualMenu::class.java))
    }

}
