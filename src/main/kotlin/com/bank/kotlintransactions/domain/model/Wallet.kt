package com.bank.kotlintransactions.domain.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import java.math.BigDecimal

@Entity
data class Wallet(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val balance: BigDecimal,
    @OneToOne
    val user: User,
    val pix: String,
    val ag: String,
    val acc: String
)
