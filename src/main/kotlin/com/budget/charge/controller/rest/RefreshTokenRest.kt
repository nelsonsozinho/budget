package com.budget.charge.controller.rest

import java.time.Instant

data class RefreshTokenRest(
    val refreshToken: String?,
    val expiredDate: Instant?,
    val token: String?
) {

}