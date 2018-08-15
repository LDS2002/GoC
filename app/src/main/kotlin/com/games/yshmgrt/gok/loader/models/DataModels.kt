package com.games.yshmgrt.gok.loader.models

import kotlinx.serialization.Serializable

@Serializable
data class LevelInfo(var id : Int, var name : String, var description : String)