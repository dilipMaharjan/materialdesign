package com.learn.materialdesign.materialdesign

import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.view.ActionMode
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_contextual_menu.*

class ContextualMenu : AppCompatActivity(), Toolbar.OnMenuItemClickListener, View.OnLongClickListener {

    var mActionMode: ActionMode? = null

    override fun onMenuItemClick(item: MenuItem): Boolean {
        val title = item.title
        when (item.itemId) {
            R.id.save -> Toast.makeText(this, title, Toast.LENGTH_SHORT).show()
            R.id.settings -> Toast.makeText(this, title, Toast.LENGTH_SHORT).show()
            R.id.help -> Toast.makeText(this, title, Toast.LENGTH_SHORT).show()
        }
        return true
    }


    override fun onLongClick(v: View): Boolean {
        mActionMode = startSupportActionMode(myActionModeCallback)!!
        return true
    }

    private val myActionModeCallback = object : ActionMode.Callback {
        override fun onCreateActionMode(mode: ActionMode, menu: Menu): Boolean {
            mode.menuInflater.inflate(R.menu.context_menu, menu)
            mode.title = "Choose your option"
            return true
        }

        override fun onPrepareActionMode(mode: ActionMode, menu: Menu): Boolean {
            return false
        }

        override fun onActionItemClicked(mode: ActionMode, item: MenuItem): Boolean {
            return false
        }

        override fun onDestroyActionMode(mode: ActionMode) {
            mActionMode = null
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contextual_menu)

        val mToolBar = toolbar as Toolbar
        mToolBar.title = "Context Menu"
        mToolBar.subtitle = "Context Menu Subtitle"
        mToolBar.navigationIcon = resources.getDrawable(R.drawable.ic_arrow_back_black_24dp)

        //Programmatically applying elevation

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) mToolBar.elevation = 10f

        //Inflating menu into toolbar

        mToolBar.inflateMenu(R.menu.main)
        mToolBar.setOnMenuItemClickListener(this)
        contextBtn.setOnLongClickListener(this)

    }
}
