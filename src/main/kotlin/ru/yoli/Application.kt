package ru.yoli

import io.ktor.server.cio.*
import io.ktor.server.engine.*
import org.jetbrains.exposed.sql.Database
import ru.yoli.features.login.configureLoginRouting
import ru.yoli.features.register.configureRegisterRouting
import ru.yoli.plugins.configureRouting

fun main() {
    Database.connect(
        "jdbc:postgresql://127.0.0.1:5432/yoli",
        driver = "org.postgresql.Driver",
        user = "postgres",
        password = "12345678"
    )
    embeddedServer(CIO, port = 8080, host = "0.0.0.0") {
        configureRouting()
        configureLoginRouting()
        configureRegisterRouting()
        configureSerialization()
    }.start(wait = true)
}
