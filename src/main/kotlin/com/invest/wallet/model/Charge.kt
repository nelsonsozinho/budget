package com.invest.wallet.model

import java.math.BigDecimal
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.ManyToOne

@Entity
data class Charge(

    @Column(nullable = false)
    var amount: Double,

    var tag: String,

    var description: String?,

    @ManyToOne(cascade = [CascadeType.ALL])
    var user: User? = null,

    ): AbstractEntity() {
}