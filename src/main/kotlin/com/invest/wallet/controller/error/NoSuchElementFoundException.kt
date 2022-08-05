package com.invest.wallet.controller.error

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class NoSuchElementFoundException : ResponseStatusException {

    constructor(status: HttpStatus, reason: String) : super(HttpStatus.NOT_FOUND, reason)

}