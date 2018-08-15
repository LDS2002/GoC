package com.games.yshmgrt.gok.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.games.yshmgrt.gok.views.MainActivityView
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityView().setContentView(this)
    }
}