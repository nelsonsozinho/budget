package com.budget.charge.repository

import com.budget.charge.model.Charge
import com.budget.charge.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ChargeRepository: JpaRepository<Charge, UUID> {

    fun findChargeByIdAndUser(id: UUID?, user: User): Optional<Charge>

    fun findChargesByUserId(id: UUID?): List<Charge>

}