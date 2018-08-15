package com.games.yshmgrt.gok.activities.mainactivity.views.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.games.yshmgrt.gok.loader.models.LevelInfo
import com.games.yshmgrt.gok.activities.mainactivity.views.MainViewRecyclerItem
import org.jetbrains.anko.AnkoContext

class MainViewRecyclerAdapter(private val src : List<LevelInfo>) : RecyclerView.Adapter<MainViewRecyclerAdapter.MainViewRecyclerHolder>() {

    override fun getItemCount() = src.size

    override fun onBindViewHolder(p0: MainViewRecyclerHolder, p1: Int) = p0.bindItem(src[p1])

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int) = MainViewRecyclerHolder(MainViewRecyclerItem(), p0)

    class MainViewRecyclerHolder(private val item : MainViewRecyclerItem, p0: ViewGroup) : RecyclerView.ViewHolder(item.createView(AnkoContext.create(p0.context, p0))) {
        fun bindItem(info: LevelInfo) {
            item.nameTextView.text = info.name
            item.descriptionTextView.text = info.description
        }
    }
}