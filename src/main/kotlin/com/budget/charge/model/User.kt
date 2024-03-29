package com.budget.charge.model

import com.budget.charge.controller.rest.UserRest
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Type
import java.io.Serializable
import java.util.*
import javax.persistence.*

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
