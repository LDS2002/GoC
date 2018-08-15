package com.games.yshmgrt.gok.loader

import android.content.Context
import com.games.yshmgrt.gok.R
import com.games.yshmgrt.gok.loader.models.LevelInfo
import com.games.yshmgrt.gok.loader.parsers.deserializeLevelInfo

object DataLoader {
    var levelInfoList = listOf<LevelInfo>()
    fun load(context: Context) {
        levelInfoList = deserializeLevelInfo(context.resources.openRawResource(R.raw.level_info).bufferedReader().use { it.readLine() })
    }
}