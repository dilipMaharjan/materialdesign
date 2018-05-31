package com.learn.materialdesign.materialdesign

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_stand_alone_tool_bar.*

class ToolBarAsActionBar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tool_bar_as_action_bar)
        val mToolbar = toolbar as Toolbar?
        setSupportActionBar(mToolbar)
        supportActionBar?.apply {
            title = "Actionbar Title"
            subtitle = "Actionbar Subtitle"
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val title = item.title
        when (item.itemId) {
            R.id.save -> Toast.makeText(this, title, Toast.LENGTH_SHORT).show()
            R.id.settings -> Toast.makeText(this, title, Toast.LENGTH_SHORT).show()
            R.id.help -> Toast.makeText(this, title, Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

}
