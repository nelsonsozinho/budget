package com.invest.wallet.model

import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Type

@Entity
@Table(name = "charge_role")
class Role {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type="org.hibernate.type.UUIDCharType")
    @Column(name = "id")
    var id: UUID? = null
        set(id) {
            field = this.id
        }

    @Column(name = "role_name")
    var roleName: String? = null
        set(roleName) {
            field = this.roleName
        }

    @Column(name = "description")
    var description: String? = null
        set(description) {
            field = this.description
        }
}