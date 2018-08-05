package com.games.yshmgrt.gok

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.appcompat.v7.linearLayoutCompat
import org.jetbrains.anko.button
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.toast

@Suppress("EXPERIMENTAL_FEATURE_WARNING")
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        linearLayoutCompat {
            button("Hello, World!") {
                onClick {
                    toast("Hello, World!").show()
                }
            }
        }
    }
}
