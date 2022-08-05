package com.invest.wallet.repository

import com.invest.wallet.model.Charge
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ChargeRepository: JpaRepository<Charge, UUID> {

    fun findChargesByUserId(id: UUID?): List<Charge>

}