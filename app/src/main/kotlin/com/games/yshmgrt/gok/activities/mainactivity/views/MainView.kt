package com.games.yshmgrt.gok.activities.mainactivity.views

import android.support.v4.view.GravityCompat
import com.games.yshmgrt.gok.R
import com.games.yshmgrt.gok.activities.mainactivity.MainActivity
import com.games.yshmgrt.gok.activities.mainactivity.views.fragments.LevelListFragment
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.design.navigationView
import org.jetbrains.anko.linearLayout
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.support.v4.drawerLayout


class MainView : AnkoComponent<MainActivity>{

    override fun createView(ui: AnkoContext<MainActivity>) = ui.apply {
        drawerLayout {
            id = R.id.drawer_layout_main_activity
            fitsSystemWindows = true
            lparams(width = matchParent, height = matchParent)

            linearLayout {
                id = R.id.fragment_main_activity
                ui.owner.supportFragmentManager.beginTransaction().add(R.id.fragment_main_activity, LevelListFragment()).commit()
            }.lparams(width = matchParent, height = matchParent)

            navigationView {
                id = R.id.navigation_drawer_main_activity
                fitsSystemWindows = true
                inflateMenu(R.menu.navigation_drawer_main_activity)
            }.lparams(height = matchParent, gravity = GravityCompat.START)
        }

    }.view
}