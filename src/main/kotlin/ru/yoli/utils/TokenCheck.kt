package ru.yoli.utils

import ru.yoli.database.tokens.Tokens

object TokenCheck {
    fun isTokenValid(token: String): Boolean = Tokens.fetchTokens().firstOrNull { it.token == token } != null
    fun isTokenAdmin(token: String): Boolean = token == "4acaecee-1552-4bf0-b004-04c567f81cb8"
}