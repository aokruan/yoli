package ru.yoli.features.register

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ru.yoli.features.cache.InMemoryCache
import ru.yoli.features.cache.TokenCache
import ru.yoli.features.utils.isValidEmail
import java.util.*

fun Application.configureRegisterRouting() {

    routing {
        post("/register") {
            val receive = call.receive<RegisterReceiveRemote>()
            if (!receive.email.isValidEmail()) {
                call.respond(HttpStatusCode.BadRequest, "Email is not valid.")
            }

            if (InMemoryCache.userList.map { it.login }.contains(receive.login)) {
                call.respond(HttpStatusCode.Conflict, "User already exists.")
            }

            val token = UUID.randomUUID().toString()
            InMemoryCache.userList.add(receive)
            InMemoryCache.token.add(TokenCache(login = receive.login, token = token))

            call.respond(RegisterResponseRemote(token = token))
        }
    }
}