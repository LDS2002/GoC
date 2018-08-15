package com.games.yshmgrt.gok.activities.mainactivity.views

import android.support.constraint.ConstraintSet.PARENT_ID
import android.view.ViewGroup
import android.widget.TextView
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView
import org.jetbrains.anko.constraint.layout.ConstraintSetBuilder.Side.*
import org.jetbrains.anko.constraint.layout.applyConstraintSet
import org.jetbrains.anko.constraint.layout.constraintLayout

class MainViewRecyclerItem : AnkoComponent<ViewGroup> {
    lateinit var nameTextView : TextView
    lateinit var descriptionTextView : TextView
    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        cardView {
            lparams(width = matchParent) {
                marginStart = dip(8)
                marginEnd = dip(8)
                topMargin = dip(8)
                bottomMargin = dip(8)
            }
            cardElevation = dip(4).toFloat()
            constraintLayout {
                nameTextView = textView {
                    text = "name"
                    id = ViewGroup.generateViewId()
                }.lparams(width = wrapContent, height = wrapContent)
                descriptionTextView = textView {
                    text = "description"
                    id = ViewGroup.generateViewId()
                }.lparams(width = matchParent, height = wrapContent)
                applyConstraintSet {
                    nameTextView {
                        connect(
                                TOP to TOP of PARENT_ID,
                                LEFT to LEFT of PARENT_ID,
                                RIGHT to RIGHT of PARENT_ID,
                                BOTTOM to TOP of descriptionTextView
                        )
                        horizontalBias = 0.1f
                    }
                    descriptionTextView {
                        connect(
                                TOP to BOTTOM of nameTextView,
                                LEFT to LEFT of PARENT_ID,
                                RIGHT to RIGHT of PARENT_ID,
                                BOTTOM to BOTTOM of PARENT_ID
                        )
                        horizontalBias = 0.7f
                    }
                }
            }.lparams(width = matchParent)
        }
    }
}