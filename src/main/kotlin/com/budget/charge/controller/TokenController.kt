package com.budget.charge.controller

import com.budget.charge.controller.error.TokenRefreshException
import com.budget.charge.controller.rest.RefreshTokenRest
import com.budget.charge.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping(value = ["/token"], produces = [MediaType.APPLICATION_JSON_VALUE])
class TokenController(
    private val userService: UserService
) {

    @PostMapping("/refresh")
    @ResponseStatus(HttpStatus.OK)
    fun refreshToken(@RequestBody body: RefreshTokenRest): ResponseEntity<RefreshTokenRest> {
        return userService.findUserByRefreshToken(body.refreshToken!!)
            .map { userService::verifyInspiration }
            .map {
                val refreshTokenRest = userService.updateRefreshToken(body.refreshToken)
                return@map ResponseEntity.ok(refreshTokenRest)
            }.orElseThrow {
                TokenRefreshException(body.refreshToken, "Refresh token is not in the database")
            }
    }

}