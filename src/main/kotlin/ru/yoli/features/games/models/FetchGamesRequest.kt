package ru.yoli.features.games.models

import kotlinx.serialization.Serializable

@Serializable
data class FetchGamesRequest(
    val searchQuery: String
)