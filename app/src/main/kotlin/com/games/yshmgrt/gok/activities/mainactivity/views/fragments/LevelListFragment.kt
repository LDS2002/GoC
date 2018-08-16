package com.games.yshmgrt.gok.activities.mainactivity.views.fragments

import android.graphics.Color
import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.games.yshmgrt.gok.R
import com.games.yshmgrt.gok.activities.mainactivity.MainActivity
import com.games.yshmgrt.gok.activities.mainactivity.views.adapters.MainViewRecyclerAdapter
import com.games.yshmgrt.gok.loader.DataLoader
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.navigationIconResource
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.constraint.layout.ConstraintSetBuilder
import org.jetbrains.anko.constraint.layout.applyConstraintSet
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.support.v4.dip

class LevelListFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return UI {
            constraintLayout {
                lparams(width = matchParent, height = matchParent)
                id = R.id.fragment_main_activity
                val recycler = recyclerView {
                    id = ViewGroup.generateViewId()
                    adapter = MainViewRecyclerAdapter(DataLoader.levelInfoList)
                    layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                }.lparams(width = matchParent, height = 0)

                val toolbar = toolbar {
                    id = R.id.toolbar_main_activity
                    backgroundColorResource = R.color.colorPrimary
                    setTitleTextColor(Color.WHITE)
                    title = "Hello, World!"
                    elevation = dip(8).toFloat()
                    navigationIconResource = R.drawable.ic_menu_white_24dp
                    setNavigationOnClickListener {
                        (activity as MainActivity).drawer.openDrawer(GravityCompat.START)
                        toast("Hello")
                    }
                }.lparams(width = matchParent)
                (activity as MainActivity).apply {
                    setSupportActionBar(toolbar)
                    supportActionBar?.apply {
                        setDisplayHomeAsUpEnabled(true)
                        setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp)
                    }
                }

                applyConstraintSet {
                    toolbar {
                        connect(
                                ConstraintSetBuilder.Side.TOP to ConstraintSetBuilder.Side.TOP of ConstraintSet.PARENT_ID,
                                ConstraintSetBuilder.Side.LEFT to ConstraintSetBuilder.Side.LEFT of ConstraintSet.PARENT_ID,
                                ConstraintSetBuilder.Side.RIGHT to ConstraintSetBuilder.Side.RIGHT of ConstraintSet.PARENT_ID,
                                ConstraintSetBuilder.Side.BOTTOM to ConstraintSetBuilder.Side.TOP of recycler
                        )
                    }
                    recycler {
                        connect(
                                ConstraintSetBuilder.Side.TOP to ConstraintSetBuilder.Side.BOTTOM of toolbar,
                                ConstraintSetBuilder.Side.LEFT to ConstraintSetBuilder.Side.LEFT of ConstraintSet.PARENT_ID,
                                ConstraintSetBuilder.Side.RIGHT to ConstraintSetBuilder.Side.RIGHT of ConstraintSet.PARENT_ID,
                                ConstraintSetBuilder.Side.BOTTOM to ConstraintSetBuilder.Side.BOTTOM of ConstraintSet.PARENT_ID
                        )
                    }
                }
            }
        }.view
    }
}