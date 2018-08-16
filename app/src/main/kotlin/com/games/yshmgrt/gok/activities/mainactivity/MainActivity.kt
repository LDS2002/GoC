package com.games.yshmgrt.gok.activities.mainactivity

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.games.yshmgrt.gok.R
import com.games.yshmgrt.gok.activities.mainactivity.views.MainView
import com.games.yshmgrt.gok.activities.mainactivity.views.fragments.LessonsListFragment
import com.games.yshmgrt.gok.activities.mainactivity.views.fragments.LevelListFragment
import com.games.yshmgrt.gok.loader.DataLoader
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView

class MainActivity : AppCompatActivity(){

    lateinit var drawer : DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataLoader.load(this)
        MainView().setContentView(this)

        drawer = find(R.id.drawer_layout_main_activity)

        val navigationView = find<NavigationView>(R.id.navigation_drawer_main_activity)
        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.levels -> supportFragmentManager.beginTransaction().replace(R.id.fragment_main_activity, LevelListFragment()).commit()
                R.id.lessons -> supportFragmentManager.beginTransaction().replace(R.id.fragment_main_activity, LessonsListFragment()).commit()
            }
            drawer.closeDrawer(GravityCompat.START)
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
            android.R.id.home -> {
                drawer.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}