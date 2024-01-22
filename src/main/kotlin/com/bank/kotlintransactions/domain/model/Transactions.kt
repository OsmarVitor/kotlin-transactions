package com.bank.kotlintransactions.domain.model

import com.bank.kotlintransactions.domain.model.enums.TransactionStatus
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
data class Transactions(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @ManyToOne
    val senderUser: User,
    @ManyToOne
    val receivingUser: User,
    val value: BigDecimal,
    val date: LocalDateTime,
    @Enumerated(EnumType.STRING)
    val status: TransactionStatus
)
