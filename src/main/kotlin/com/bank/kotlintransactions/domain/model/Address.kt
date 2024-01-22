package com.bank.kotlintransactions.domain.model

import jakarta.persistence.*

@Entity(name = "address")
data class Address(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val zipCode: String,
    val number: String,
    val complement: String,
    val neighborhood: String,
    val street: String,
    @ManyToOne
    var city: City
    )