package com.games.yshmgrt.gok.activities.mainactivity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.games.yshmgrt.gok.R
import com.games.yshmgrt.gok.activities.mainactivity.views.MainView
import com.games.yshmgrt.gok.loader.DataLoader
import org.jetbrains.anko.findOptional
import org.jetbrains.anko.setContentView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataLoader.load(this)
        MainView().setContentView(this)
        setSupportActionBar(findOptional(R.id.toolbar_main_activity))
    }
}