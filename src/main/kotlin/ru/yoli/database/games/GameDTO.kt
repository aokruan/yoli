package ru.yoli.database.games

import kotlinx.serialization.Serializable
import ru.yoli.features.games.models.CreateGameRequest
import ru.yoli.features.games.models.CreateGameResponse
import java.util.*

@Serializable
data class GameDTO(
    val gameID: String,
    val title: String,
    val description: String,
    val version: String,
    val size: Double
)

fun CreateGameRequest.mapToGameDTO(): GameDTO =
    GameDTO(
        gameID = UUID.randomUUID().toString(),
        title = title,
        description = description,
        version = version,
        size = size
    )

fun GameDTO.mapToCreateGameResponse(): CreateGameResponse =
    CreateGameResponse(
        gameID = gameID,
        title = title,
        description = description,
        version = version,
        size = size
    )