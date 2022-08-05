package com.invest.wallet.controller.rest

import com.invest.wallet.model.User
import java.util.UUID

data class UserRest(
    var id: UUID?,
    var username: String?,
    var password: String?,
    var firstName: String?,
    var lastName: String?,
) {

    fun toUser() = User(
        id = id,
        username = username,
        password = password,
        firstName = firstName,
        lastName = lastName
    )

}