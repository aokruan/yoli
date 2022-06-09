package ru.yoli.features.database.games

data class GameDTO(
    val gameId: String,
    val name: String,
    val backdrop: String?,
    val logo: String,
    val description: String,
    val downloadCount: Int,
    val version: String,
    val weight: String,
)