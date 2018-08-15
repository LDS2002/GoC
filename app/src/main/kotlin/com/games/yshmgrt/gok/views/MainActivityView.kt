package com.games.yshmgrt.gok.views

import android.graphics.Color
import com.games.yshmgrt.gok.activities.MainActivity
import com.games.yshmgrt.gok.R
import org.jetbrains.anko.*
import org.jetbrains.anko.design.coordinatorLayout

class MainActivityView : AnkoComponent<MainActivity> {
    override fun createView(ui: AnkoContext<MainActivity>) = ui.apply {
        coordinatorLayout {
            fitsSystemWindows = true
            toolbar {
                backgroundColorResource = R.color.colorPrimary
                setTitleTextColor(Color.WHITE)
                title = "Hello, World!"
            }.lparams(width = matchParent)
            /*recyclerView {

            }.lparams(width = matchParent)*/
        }
    }.view
}