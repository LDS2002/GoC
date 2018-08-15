package com.games.yshmgrt.gok.activities.mainactivity.views

import android.graphics.Color
import android.support.constraint.ConstraintSet.PARENT_ID
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.view.ViewGroup
import com.games.yshmgrt.gok.R
import com.games.yshmgrt.gok.activities.mainactivity.MainActivity
import com.games.yshmgrt.gok.activities.mainactivity.views.adapters.MainViewRecyclerAdapter
import com.games.yshmgrt.gok.loader.DataLoader
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.ConstraintSetBuilder.Side.*
import org.jetbrains.anko.constraint.layout.applyConstraintSet
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainView : AnkoComponent<MainActivity> {
    override fun createView(ui: AnkoContext<MainActivity>) = ui.apply {
        constraintLayout {
            fitsSystemWindows = true
            val toolbar = toolbar {
                id = R.id.toolbar_main_activity
                backgroundColorResource = R.color.colorPrimary
                setTitleTextColor(Color.WHITE)
                title = "Hello, World!"
                elevation = dip(8).toFloat()
            }.lparams(width = matchParent)
            val recycler = recyclerView {
                id = ViewGroup.generateViewId()
                adapter = MainViewRecyclerAdapter(DataLoader.levelInfoList)
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            }.lparams(width = matchParent, height = 0)

            applyConstraintSet {
                toolbar {
                    connect(
                            TOP to TOP of PARENT_ID,
                            LEFT to LEFT of PARENT_ID,
                            RIGHT to RIGHT of PARENT_ID,
                            BOTTOM to TOP of recycler
                    )
                }
                recycler {
                    connect(
                            TOP to BOTTOM of toolbar,
                            LEFT to LEFT of PARENT_ID,
                            RIGHT to RIGHT of PARENT_ID,
                            BOTTOM to BOTTOM of PARENT_ID
                    )
                }
            }
        }
    }.view
}