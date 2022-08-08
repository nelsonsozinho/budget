package com.invest.wallet.repository

import com.invest.wallet.model.Charge
import com.invest.wallet.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ChargeRepository: JpaRepository<Charge, UUID> {

    fun findChargeByIdAndUser(id: UUID?, user: User): Optional<Charge>

    fun findChargesByUserId(id: UUID?): List<Charge>

}