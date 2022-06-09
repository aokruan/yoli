package ru.yoli.features.database.games

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

object Games : Table() {
    private val gameId = Games.varchar("gameId", 100)
    private val name = Games.varchar("name", 100)
    private val backdrop = Games.varchar("backdrop", 50).nullable()
    private val logo = Games.varchar("logo", 50)
    private val description = Games.varchar("description", 500)
    private val downloadCount = Games.integer("download_count")
    private val version = Games.varchar("version", 15)
    private val weight = Games.varchar("weight", 10)

    fun insert(gameDTO: GameDTO) {
        transaction {
            Games.insert {
                it[gameId] = gameDTO.gameId
                it[name] = gameDTO.name
                it[backdrop] = gameDTO.backdrop
                it[logo] = gameDTO.logo
                it[description] = gameDTO.description
                it[downloadCount] = gameDTO.downloadCount
                it[version] = gameDTO.version
                it[weight] = gameDTO.weight
            }
        }
    }

    fun fetchGames(): List<GameDTO> {
        return try {
            transaction {
                Games.selectAll().toList()
                    .map {
                        GameDTO(
                            gameId = it[Games.gameId],
                            name = it[Games.name],
                            backdrop = it[Games.backdrop],
                            logo = it[Games.logo],
                            description = it[Games.description],
                            downloadCount = it[Games.downloadCount],
                            version = it[Games.version],
                            weight = it[Games.weight]
                        )
                    }
            }
        } catch (e: Exception) {
            emptyList()
        }
    }
}
