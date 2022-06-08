package ru.yoli

import io.ktor.server.cio.*
import io.ktor.server.engine.*
import ru.yoli.features.login.configureLoginRouting
import ru.yoli.features.register.configureRegisterRouting
import ru.yoli.plugins.configureRouting

fun main() {
    embeddedServer(CIO, port = 8080, host = "0.0.0.0") {
        configureRouting()
        configureLoginRouting()
        configureRegisterRouting()
        configureSerialization()
    }.start(wait = true)
}
