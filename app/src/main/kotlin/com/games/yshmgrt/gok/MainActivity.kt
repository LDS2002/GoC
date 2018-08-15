package com.games.yshmgrt.gok

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.design.coordinatorLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainView().setContentView(this)
    }

    class MainView : AnkoComponent<MainActivity>{
        override fun createView(ui: AnkoContext<MainActivity>) = ui.apply {
            coordinatorLayout {
                fitsSystemWindows = true
                toolbar {
                    backgroundColorResource = R.color.colorPrimary
                    setTitleTextColor(Color.WHITE)
                    title = "Hello, World!"
                }.lparams(width = matchParent)
            }
        }.view
    }
}