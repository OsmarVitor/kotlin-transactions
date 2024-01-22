package com.bank.kotlintransactions.domain.model

import jakarta.persistence.*
import org.springframework.context.annotation.Lazy
import java.time.LocalDate

@Entity(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String,
    val birthDate: LocalDate,
    @ManyToOne
    @Lazy
    val address: Address,
    @ManyToOne
    val wallet: Wallet

)
