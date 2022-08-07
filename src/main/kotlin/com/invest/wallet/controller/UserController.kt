package com.invest.wallet.controller

import com.invest.wallet.controller.rest.UserRest
import com.invest.wallet.model.User
import com.invest.wallet.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping(value = ["/user"], produces = [MediaType.APPLICATION_JSON_VALUE])
class UserController(
    private val passwordEncoder: PasswordEncoder,
    private val userService: UserService,
) {

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    fun saveUser(@RequestBody userRest: UserRest): ResponseEntity<UserRest> {
        userRest.password = passwordEncoder.encode(userRest.password)
        val user = userRest.toUser()
        val newUser: User = userService.saveUser(user)
        return ResponseEntity(newUser.toUserRest(), HttpStatus.CREATED)
    }

}