package com.invest.wallet.service

import com.invest.wallet.controller.error.NoSuchElementFoundException
import com.invest.wallet.controller.error.message.HttpErrorMessage
import com.invest.wallet.model.Charge
import com.invest.wallet.repository.ChargeRepository
import org.springframework.http.HttpStatus
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

@Service
class ChargeService(
    private val chargeRepository: ChargeRepository,
    private val userService: UserService
) {

    fun findById(id: UUID): Charge {
        val user = userService.findUserByUserName(SecurityContextHolder.getContext().authentication.principal as String);
        return chargeRepository.findChargeByIdAndUser(id, user).orElseThrow { NoSuchElementFoundException(HttpStatus.NOT_FOUND,
            HttpErrorMessage.OBJECT_HOT_FOUND.message.replace("{id}", id.toString())) }
    }

    fun findAll(): List<Charge> {
        val user = userService.findUserByUserName(SecurityContextHolder.getContext().authentication.principal as String);
        return chargeRepository.findChargesByUserId(user.id)
    }

    @Transactional
    fun saveCharge(charge: Charge): Charge {
        val user = userService.findUserByUserName(SecurityContextHolder.getContext().authentication.principal as String);
        charge.user = user
        return chargeRepository.save(charge)
    }

    fun listAllChargesByUserId(userId: UUID): List<Charge> = chargeRepository.findChargesByUserId(userId)

}