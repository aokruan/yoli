package ru.yoli

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.server.engine.*
import io.ktor.server.cio.*
import io.ktor.server.netty.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.DatabaseConfig
import ru.yoli.features.games.configureGameRouting
import ru.yoli.features.login.configureLoginRouting
import ru.yoli.features.register.configureRegisterRouting
import ru.yoli.plugins.configureRouting

fun main() {
    val config = HikariConfig("hikari.properties")
    val dataSource = HikariDataSource(config)
    Database.connect(dataSource)

    embeddedServer(Netty, port = System.getenv("PORT").toInt()) {
        configureRouting()
        configureLoginRouting()
        configureRegisterRouting()
        configureGameRouting()
        configureSerialization()
    }.start(wait = true)
}
