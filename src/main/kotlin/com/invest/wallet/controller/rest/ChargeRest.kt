package com.invest.wallet.controller.rest

import java.math.BigDecimal
import java.util.UUID

data class ChargeRest(
    val id : UUID?,
    val amount: Double,
    val tag: String,
    val description: String?
) {
}