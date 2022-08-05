package com.invest.wallet.model

import com.invest.wallet.controller.rest.UserRest
import java.io.Serializable
import java.util.UUID
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.OneToMany
import javax.persistence.Table
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Type

@Entity
@Table(name = "charge_user")
class User(

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type="org.hibernate.type.UUIDCharType")
    @Column(name = "id")
    var id: UUID? = null,

    @Column(name = "username", unique = true)
    var username: String? = null,

    @Column(name = "password")
    var password: String? = null,

    @Column(name = "first_name")
    var firstName: String? = null,

    @Column(name = "last_name")
    var lastName: String? = null,

    @Column(name = "refresh_token")
    var refreshToken: String? = null,

    @ManyToMany(fetch = FetchType.EAGER, cascade = [CascadeType.MERGE])
    @JoinTable(
        name = "users_roles",
        joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "role_id", referencedColumnName = "id")]
    )
    var roles: Set<Role>? = null,

    @OneToMany(mappedBy = "user")
    var budgets: List<Charge>? = null

): Serializable {
    fun toUserRest() = UserRest(
        id = id,
        username = username,
        password = password,
        firstName = firstName,
        lastName = lastName
    )
}
