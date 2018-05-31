package com.learn.materialdesign.materialdesign

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_stand_alone_tool_bar.*

class StandAloneToolBar : AppCompatActivity(), Toolbar.OnMenuItemClickListener {
    override fun onMenuItemClick(item: MenuItem): Boolean {
        val title = item.title
        when (item.itemId) {
            R.id.save -> Toast.makeText(this, title, Toast.LENGTH_SHORT).show()
            R.id.settings -> Toast.makeText(this, title, Toast.LENGTH_SHORT).show()
            R.id.help -> Toast.makeText(this, title, Toast.LENGTH_SHORT).show()
        }
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stand_alone_tool_bar)

        val mToolBar = toolbar as Toolbar
        mToolBar.title = "Standalone Toolbar"
        mToolBar.subtitle = "Toolbar Subtitle"
        mToolBar.navigationIcon = resources.getDrawable(R.drawable.ic_arrow_back_black_24dp)

        //Programmatically applying elevation

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) mToolBar.elevation = 10f

        //Inflating menu into toolbar

        mToolBar.inflateMenu(R.menu.main)
        mToolBar.setOnMenuItemClickListener(this)
    }
}
