package com.budget.charge.controller.rest

import com.budget.charge.model.User
import java.util.*

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