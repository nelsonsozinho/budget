package com.invest.wallet.controller

import com.invest.wallet.controller.error.TokenRefreshException
import com.invest.wallet.controller.rest.RefreshTokenRest
import com.invest.wallet.service.UserService
import javax.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController


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