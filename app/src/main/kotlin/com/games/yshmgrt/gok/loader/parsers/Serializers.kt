package com.games.yshmgrt.gok.loader.parsers

import com.games.yshmgrt.gok.loader.models.LevelInfo
import kotlinx.serialization.internal.ArrayListSerializer
import kotlinx.serialization.json.JSON

val levelInfoSerializer = LevelInfo.serializer()
val levelInfoListSerializer = ArrayListSerializer(levelInfoSerializer)

fun serializeLevelInfo(list : ArrayList<LevelInfo>) = JSON.indented.stringify(levelInfoListSerializer, list)

fun deserializeLevelInfo(src : String) = JSON.indented.parse(levelInfoListSerializer, src)