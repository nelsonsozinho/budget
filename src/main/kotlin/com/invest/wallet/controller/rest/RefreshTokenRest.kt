package com.invest.wallet.controller.rest

import java.time.Instant

data class RefreshTokenRest(
    val refreshToken: String?,
    val expiredDate: Instant?,
    val token: String?
) {

}