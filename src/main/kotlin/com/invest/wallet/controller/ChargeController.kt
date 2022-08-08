package com.invest.wallet.controller

import com.invest.wallet.controller.rest.ChargeRest
import com.invest.wallet.model.Charge
import com.invest.wallet.service.ChargeService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping(value = ["/charge"], produces = [MediaType.APPLICATION_JSON_VALUE])
class ChargeController(
    private val walletService: ChargeService
) {

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getBudgetById(@PathVariable("id") id: UUID): ResponseEntity<ChargeRest> {
        val charge = walletService.findById(id)
        return ResponseEntity<ChargeRest>(ChargeRest(charge.id, charge.amount, charge.tag, charge.description, charge.lastModifiedAt), HttpStatus.OK)
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun listAllBudgets():List<ChargeRest> {
        return walletService.findAll().mapNotNull { ChargeRest(it.id, it.amount, it.tag, it.description, it.lastModifiedAt
        ) }.toMutableList()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun newBudget(@RequestBody charge: ChargeRest): ResponseEntity<ChargeRest> {
        val chargeSaved = walletService.saveCharge(Charge(description = charge.description, amount = charge.amount, tag = charge.tag))
        return ResponseEntity<ChargeRest>(ChargeRest(
            chargeSaved.id,
            chargeSaved.amount,
            chargeSaved.tag,
            chargeSaved.description,
            chargeSaved.lastModifiedAt), HttpStatus.CREATED)
    }

    @GetMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun listBudgetsByUserId(@PathVariable(name="id") id: UUID): ResponseEntity<MutableList<ChargeRest>> {
        val wallets = walletService.listAllChargesByUserId(id)
        val walletRest: MutableList<ChargeRest> = wallets.map { ChargeRest(it.id, it.amount, it.tag, it.description, it.lastModifiedAt) }.toMutableList()
        return ResponseEntity<MutableList<ChargeRest>>(walletRest, HttpStatus.OK)
    }

}

