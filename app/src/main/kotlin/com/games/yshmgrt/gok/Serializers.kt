package com.games.yshmgrt.gok

import kotlinx.serialization.internal.ArrayListSerializer
import kotlinx.serialization.json.JSON

val levelInfoSerializer = LevelInfo.serializer()
val levelInfoListSerializer = ArrayListSerializer(levelInfoSerializer)

fun serializeLevelInfo(list : ArrayList<LevelInfo>) = JSON.stringify(levelInfoListSerializer, list)

fun deserializeLevelInfo(src : String) = JSON.parse(levelInfoListSerializer, src)